package com.github.argon4w.rpsh.lexical.tokens.operators;

import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;

public class LeftBlockOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return null;
    }

    @Override
    public int getPriority() {
        return -1;
    }
}
