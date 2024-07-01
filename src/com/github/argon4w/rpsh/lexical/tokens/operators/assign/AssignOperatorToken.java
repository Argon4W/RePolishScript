package com.github.argon4w.rpsh.lexical.tokens.operators;

import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.AssignSyntaxTreeNode;

public class AssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new AssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
