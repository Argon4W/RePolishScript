package com.github.argon4w.rps.syntactic;

import com.github.argon4w.rps.lexical.IToken;
import com.github.argon4w.rps.lexical.SimpleTokenHashMap;
import com.github.argon4w.rps.lexical.tokens.operators.*;
import com.github.argon4w.rps.syntactic.nodes.stack.PushArrayStackSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.stack.PushExpressionStackSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.stack.PushStackSyntaxTreeNode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ReversePolishSyntacticTreeBuilder {
    public final SimpleTokenHashMap tokenHashMap;
    public final Stack<ISyntaxTreeNode> syntaxTreeNodes;
    public final Stack<IOperatorToken> operators;

    public ReversePolishSyntacticTreeBuilder(SimpleTokenHashMap tokenHashMap) {
        this.tokenHashMap = tokenHashMap;
        this.syntaxTreeNodes = new Stack<>();
        this.operators = new Stack<>();
    }

    public List<ISyntaxTreeNode> buildSyntaxTree(List<IToken> tokens) {
        return buildSyntaxTree(tokens.iterator());
    }

    public List<ISyntaxTreeNode> buildSyntaxTree(Iterator<IToken> tokenIterator) {
        this.syntaxTreeNodes.clear();
        this.operators.clear();

        while (tokenIterator.hasNext()) {
            IToken token = tokenIterator.next();

            if (token instanceof LeftBlockOperatorToken) {
                syntaxTreeNodes.push(new PushStackSyntaxTreeNode(new ReversePolishSyntacticTreeBuilder(tokenHashMap).buildSyntaxTree(tokenIterator)));
                continue;
            }

            if (token instanceof RightBlockOperatorToken) {
                popAllOperators();
                return syntaxTreeNodes;
            }

            if (token instanceof LeftSquareOperatorToken) {
                syntaxTreeNodes.push(new PushArrayStackSyntaxTreeNode(new ReversePolishSyntacticTreeBuilder(tokenHashMap).buildSyntaxTree(tokenIterator)));
                continue;
            }

            if (token instanceof RightSquareOperatorToken) {
                popAllOperators();
                return syntaxTreeNodes;
            }

            if (token instanceof LeftBracketOperatorToken) {
                syntaxTreeNodes.push(new PushExpressionStackSyntaxTreeNode(new ReversePolishSyntacticTreeBuilder(tokenHashMap).buildSyntaxTree(tokenIterator)));
                continue;
            }

            if (token instanceof RightBracketOperatorToken) {
                popAllOperators();
                return syntaxTreeNodes;
            }

            if (token instanceof IOperatorToken operatorToken) {
                popLowPriorityOperators(operatorToken);
                operators.push(operatorToken);

                continue;
            }

            syntaxTreeNodes.push(token.getSyntaxTreeNode());
        }

        popAllOperators();
        return syntaxTreeNodes;
    }

    public void popLowPriorityOperators(IOperatorToken token) {
        while (!operators.empty() && operators.peek().getPriority() >= token.getPriority()) {
            syntaxTreeNodes.push(popFromOperators());
        }
    }

    public void popAllOperators() {
        while (!operators.empty()) {
            syntaxTreeNodes.push(popFromOperators());
        }
    }

    public ISyntaxTreeNode popFromOperators() {
        ISyntaxTreeNode syntaxTreeNode = operators.pop().getSyntaxTreeNode();
        syntaxTreeNode.popFromStack(syntaxTreeNodes);

        return syntaxTreeNode;
    }
}
