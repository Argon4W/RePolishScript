package com.github.argon4w.rpsh.lexical.tokens.operators;

import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.ParalleledSyntaxTreeNode;

public class ParalleledOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ParalleledSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
