package com.github.argon4w.rpsh;

import com.github.argon4w.rpsh.lexical.IToken;
import com.github.argon4w.rpsh.lexical.SimpleLexicalAnalyzer;
import com.github.argon4w.rpsh.lexical.SimpleTokenHashMap;
import com.github.argon4w.rpsh.lexical.tokens.BooleanToken;
import com.github.argon4w.rpsh.lexical.tokens.UndefinedToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.*;
import com.github.argon4w.rpsh.lexical.tokens.operators.condition.*;
import com.github.argon4w.rpsh.lexical.tokens.operators.list.LenOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.list.RangeOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.list.SliceOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.logic.ShortCircuitAndOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.logic.ShortCircuitOrOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.loop.BreakOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.loop.ContinueOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.loop.ForOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.loop.WhileOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.math.AddOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.math.DivideOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.math.MultiplyOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.math.SubtractOperatorToken;
import com.github.argon4w.rpsh.lexical.tokens.operators.object.*;
import com.github.argon4w.rpsh.runtime.RuntimeBuiltinFunctions;
import com.github.argon4w.rpsh.runtime.RuntimeRootStack;
import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.calls.ReadBuiltinCall;
import com.github.argon4w.rpsh.runtime.calls.WriteBuiltinCall;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.ReversePolishSyntacticTreeBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RePolishRuntime {
    public final SimpleTokenHashMap operatorMap;
    public final SimpleTokenHashMap keywordMap;
    public final RuntimeBuiltinFunctions builtinFunctions;
    public final HashMap<Integer, RuntimeStack> importedStacks;

    public final ReversePolishSyntacticTreeBuilder syntacticTreeBuilder;
    public final SimpleLexicalAnalyzer lexicalAnalyzer;

    public RePolishRuntime() {
        operatorMap = new SimpleTokenHashMap();
        keywordMap = new SimpleTokenHashMap();
        builtinFunctions = new RuntimeBuiltinFunctions();
        importedStacks = new HashMap<>();

        operatorMap.put("&&", ShortCircuitAndOperatorToken::new);
        operatorMap.put("||", ShortCircuitOrOperatorToken::new);
        operatorMap.put("..", RangeOperatorToken::new);
        operatorMap.put("->", FunctionOperatorToken::new);
        operatorMap.put(">=", BiggerThanEqualsOperatorToken::new);
        operatorMap.put("<=", SmallerThanEqualsOperatorToken::new);
        operatorMap.put("==", EqualsOperatorToken::new);
        operatorMap.put("!=", NotEqualsOperatorToken::new);
        operatorMap.put(">", BiggerThanOperatorToken::new);
        operatorMap.put("<", SmallerThanOperatorToken::new);
        operatorMap.put(".", OfOperatorToken::new);
        operatorMap.put(",", ParalleledOperatorToken::new);
        operatorMap.put("+", AddOperatorToken::new);
        operatorMap.put("-", SubtractOperatorToken::new);
        operatorMap.put("*", MultiplyOperatorToken::new);
        operatorMap.put("/", DivideOperatorToken::new);
        operatorMap.put("=", AssignOperatorToken::new);
        operatorMap.put(";", DelimiterOperatorToken::new);
        operatorMap.put("(", LeftBracketOperatorToken::new);
        operatorMap.put(")", RightBracketOperatorToken::new);
        operatorMap.put("{", LeftBlockOperatorToken::new);
        operatorMap.put("}", RightBlockOperatorToken::new);
        operatorMap.put("[", LeftSquareOperatorToken::new);
        operatorMap.put("]", RightSquareOperatorToken::new);
        operatorMap.put("$", ReferenceOperatorToken::new);

        keywordMap.put("true", () -> new BooleanToken(true));
        keywordMap.put("false", () -> new BooleanToken(false));
        keywordMap.put("null", UndefinedToken::new);
        keywordMap.put("if", IfOperatorToken::new);
        keywordMap.put("else", ElseOperatorToken::new);
        keywordMap.put("return", ReturnOperatorToken::new);
        keywordMap.put("in", InOperatorToken::new);
        keywordMap.put("len", LenOperatorToken::new);
        keywordMap.put("slice", SliceOperatorToken::new);
        keywordMap.put("while", WhileOperatorToken::new);
        keywordMap.put("for", ForOperatorToken::new);
        keywordMap.put("continue", ContinueOperatorToken::new);
        keywordMap.put("break", BreakOperatorToken::new);
        keywordMap.put("call", CallBuiltinOperatorToken::new);
        keywordMap.put("push", PushOperatorToken::new);
        keywordMap.put("import", ImportOperatorToken::new);

        builtinFunctions.put("write", new WriteBuiltinCall());
        builtinFunctions.put("read", new ReadBuiltinCall());

        syntacticTreeBuilder = new ReversePolishSyntacticTreeBuilder(operatorMap);
        lexicalAnalyzer = new SimpleLexicalAnalyzer(operatorMap, keywordMap);
    }

    public RuntimeStack importRuntimeStack(String path) throws IOException {
        String string = readFileString(path);
        int hashCode = path.hashCode();
        return importedStacks.computeIfAbsent(hashCode, i -> loadRuntimeStack(string));
    }

    public RuntimeStack loadRuntimeStack(String string) {
        List<IToken> tokens = getTokens(string);
        List<ISyntaxTreeNode> treeNodes = getSyntaxTreeNodes(tokens);
        List<IInstruction> instructions = getInstructions(treeNodes);

        return getRuntimeStack(instructions);
    }

    public String readFileString(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public List<IToken> getTokens(String string) {
        return lexicalAnalyzer.tokenize(string);
    }

    public List<ISyntaxTreeNode> getSyntaxTreeNodes(List<IToken> tokens) {
        return syntacticTreeBuilder.buildSyntaxTree(tokens);
    }

    public List<IInstruction> getInstructions(List<ISyntaxTreeNode> treeNodes) {
        return treeNodes.stream().map(ISyntaxTreeNode::getInstructions).flatMap(Collection::stream).toList();
    }

    public RuntimeStack getRuntimeStack(List<IInstruction> instructions) {
        return new RuntimeRootStack(instructions, builtinFunctions, this);
    }
}
