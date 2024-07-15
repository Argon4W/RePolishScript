package com.github.argon4w.rps.lexical.tokens.operators;

import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.LazySyntaxTreeNode;

public class LazyOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new LazySyntaxTreeNode();
    }
}
