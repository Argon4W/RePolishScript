package com.github.argon4w.rps.lexical.tokens.operators.logic;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.logic.NotSyntaxTreeNode;

public class NotOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 16;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new NotSyntaxTreeNode();
    }
}
