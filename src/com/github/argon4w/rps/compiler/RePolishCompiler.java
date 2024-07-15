package com.github.argon4w.rps.compiler;

import com.github.argon4w.rps.lexical.IToken;
import com.github.argon4w.rps.lexical.SimpleLexicalAnalyzer;
import com.github.argon4w.rps.lexical.SimpleTokenHashMap;
import com.github.argon4w.rps.lexical.tokens.BooleanToken;
import com.github.argon4w.rps.lexical.tokens.UndefinedToken;
import com.github.argon4w.rps.lexical.tokens.VaParameterToken;
import com.github.argon4w.rps.lexical.tokens.operators.*;
import com.github.argon4w.rps.lexical.tokens.operators.assign.*;
import com.github.argon4w.rps.lexical.tokens.operators.bit.*;
import com.github.argon4w.rps.lexical.tokens.operators.condition.*;
import com.github.argon4w.rps.lexical.tokens.operators.list.*;
import com.github.argon4w.rps.lexical.tokens.operators.logic.NotOperatorToken;
import com.github.argon4w.rps.lexical.tokens.operators.logic.ShortCircuitAndOperatorToken;
import com.github.argon4w.rps.lexical.tokens.operators.logic.ShortCircuitOrOperatorToken;
import com.github.argon4w.rps.lexical.tokens.operators.loop.*;
import com.github.argon4w.rps.lexical.tokens.operators.math.*;
import com.github.argon4w.rps.lexical.tokens.operators.object.*;
import com.github.argon4w.rps.lexical.tokens.type.*;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.ReversePolishSyntacticTreeBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RePolishCompiler {
    public final SimpleTokenHashMap operatorMap;
    public final SimpleTokenHashMap keywordMap;
    public final List<CompiledStack> compiledStacks;

    public final ReversePolishSyntacticTreeBuilder syntacticTreeBuilder;
    public final SimpleLexicalAnalyzer lexicalAnalyzer;

    public RePolishCompiler() {
        operatorMap = new SimpleTokenHashMap();
        keywordMap = new SimpleTokenHashMap();
        compiledStacks = new ArrayList<>();

        operatorMap.put("...", VaParameterToken::new);
        operatorMap.put("??", ShortCircuitFallbackOperatorToken::new);
        operatorMap.put("&&", ShortCircuitAndOperatorToken::new);
        operatorMap.put("||", ShortCircuitOrOperatorToken::new);
        operatorMap.put("?", FallbackOperatorToken::new);
        operatorMap.put("&", BitAndOperatorToken::new);
        operatorMap.put("|", BitOrOperatorToken::new);
        operatorMap.put("^", BitXOROperatorToken::new);
        operatorMap.put("->", FunctionOperatorToken::new);
        operatorMap.put(">>>", BitUnsignedRightShiftOperatorToken::new);
        operatorMap.put("<<", BitLeftShiftOperatorToken::new);
        operatorMap.put(">>", BitRightShiftOperatorToken::new);
        operatorMap.put(">=", BiggerThanEqualsOperatorToken::new);
        operatorMap.put("<=", SmallerThanEqualsOperatorToken::new);
        operatorMap.put("==", EqualsOperatorToken::new);
        operatorMap.put("!=", NotEqualsOperatorToken::new);
        operatorMap.put("+=", AddAssignOperatorToken::new);
        operatorMap.put("-=", SubtractAssignOperatorToken::new);
        operatorMap.put("*=", MultiplyAssignOperatorToken::new);
        operatorMap.put("/=", DivideAssignOperatorToken::new);
        operatorMap.put("%=", ModAssignOperatorToken::new);
        operatorMap.put("&=", BitAndAssignOperatorToken::new);
        operatorMap.put("|=", BitOrAssignOperatorToken::new);
        operatorMap.put("^=", BitXORAssignOperatorToken::new);
        operatorMap.put("<<=", BitLeftShiftAssignOperatorToken::new);
        operatorMap.put(">>=", BitRightShiftAssignOperatorToken::new);
        operatorMap.put(">>>=", BitUnsignedRightShiftAssignOperatorToken::new);
        operatorMap.put("?=", FallbackAssignOperatorToken::new);
        operatorMap.put("??=", ShortCircuitFallbackAssignOperatorToken::new);
        operatorMap.put("!", NotOperatorToken::new);
        operatorMap.put("~", BitNotOperatorToken::new);
        operatorMap.put(">", BiggerThanOperatorToken::new);
        operatorMap.put("<", SmallerThanOperatorToken::new);
        operatorMap.put(".", OfOperatorToken::new);
        operatorMap.put("?.", FallbackOfOperatorToken::new);
        operatorMap.put(",", ParalleledOperatorToken::new);
        operatorMap.put("+", AddOperatorToken::new);
        operatorMap.put("-", SubtractOperatorToken::new);
        operatorMap.put("*", MultiplyOperatorToken::new);
        operatorMap.put("/", DivideOperatorToken::new);
        operatorMap.put("%", ModOperatorToken::new);
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
        keywordMap.put("to", RangeOperatorToken::new);
        keywordMap.put("step", StepOperatorToken::new);
        keywordMap.put("while", WhileOperatorToken::new);
        keywordMap.put("for", ForOperatorToken::new);
        keywordMap.put("continue", ContinueOperatorToken::new);
        keywordMap.put("break", BreakOperatorToken::new);
        keywordMap.put("call", CallBuiltinOperatorToken::new);
        keywordMap.put("push", PushOperatorToken::new);
        keywordMap.put("import", ImportOperatorToken::new);
        keywordMap.put("as", AsOperatorToken::new);
        keywordMap.put("is", IsOperatorToken::new);
        keywordMap.put("has", HasOperatorToken::new);
        keywordMap.put("inclusive", ClosedRangeEdgeOperatorToken::new);
        keywordMap.put("exclusive", OpenRangeEdgeOperatorToken::new);
        keywordMap.put("when", WhenOperatorToken::new);
        keywordMap.put("every", EveryOperatorToken::new);
        keywordMap.put("lazy", LazyOperatorToken::new);

        keywordMap.put("boolean", BooleanTypeToken::new);
        keywordMap.put("byte", ByteTypeToken::new);
        keywordMap.put("float", FloatingPointNumberTypeToken::new);
        keywordMap.put("function", FunctionTypeToken::new);
        keywordMap.put("integer", IntegerTypeToken::new);
        keywordMap.put("list", ListTypeToken::new);
        keywordMap.put("number", NumberTypeToken::new);
        keywordMap.put("range", RangeTypeToken::new);
        keywordMap.put("object", StackTypeToken::new);
        keywordMap.put("string", StringTypeToken::new);
        keywordMap.put("character", WideCharacterTypeToken::new);

        syntacticTreeBuilder = new ReversePolishSyntacticTreeBuilder(operatorMap);
        lexicalAnalyzer = new SimpleLexicalAnalyzer(operatorMap, keywordMap);
    }

    public CompiledScript compileScript(Path path) throws IOException {
        String string = Files.readString(path);
        return compileScript(string);
    }

    public CompiledScript compileScript(String string) {
        List<IToken> tokens = analyzeTokens(string);
        List<ISyntaxTreeNode> treeNodes = analyzeSyntaxTreeNodes(tokens);

        int rootStack = compileStack(treeNodes);
        return new CompiledScript(compiledStacks.toArray(CompiledStack[]::new), rootStack);
    }

    public int compileStack(List<ISyntaxTreeNode> treeNodes) {
        compiledStacks.add(new CompiledStack(compile(treeNodes)));
        return compiledStacks.size() - 1;
    }

    public List<IToken> analyzeTokens(String string) {
        return lexicalAnalyzer.tokenize(string);
    }

    public List<ISyntaxTreeNode> analyzeSyntaxTreeNodes(List<IToken> tokens) {
        return syntacticTreeBuilder.buildSyntaxTree(tokens);
    }

    public IInstruction[] compile(List<ISyntaxTreeNode> treeNodes) {
        return treeNodes.stream().map(iSyntaxTreeNode -> iSyntaxTreeNode.compile(this)).flatMap(Collection::stream).toArray(IInstruction[]::new);
    }
}
