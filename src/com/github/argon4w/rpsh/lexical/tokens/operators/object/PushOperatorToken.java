package com.github.argon4w.rpsh.lexical.tokens.operators;

import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.PushSyntaxTreeNode;

public class PushOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new PushSyntaxTreeNode();
    }
}
