package com.github.argon4w.rps.lexical.tokens.operators;

import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

public class RightBracketOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return null;
    }

    @Override
    public int getPriority() {
        return -1;
    }
}