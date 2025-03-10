package com.github.argon4w.rps.lexical.tokens.operators;

import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.IsSyntaxTreeNode;

public class IsOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 19;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new IsSyntaxTreeNode();
    }
}
