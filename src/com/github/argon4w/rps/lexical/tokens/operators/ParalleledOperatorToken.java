package com.github.argon4w.rps.lexical.tokens.operators;

import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.ParalleledSyntaxTreeNode;

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
