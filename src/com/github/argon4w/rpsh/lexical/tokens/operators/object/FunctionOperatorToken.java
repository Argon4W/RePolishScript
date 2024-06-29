package com.github.argon4w.rpsh.lexical.tokens.operators.object;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.object.FunctionSyntaxTreeNode;

public class FunctionOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new FunctionSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 15;
    }
}
