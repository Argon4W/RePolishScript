package com.github.argon4w.rps.lexical.tokens.operators.logic;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.logic.ShortCircuitAndSyntaxTreeNode;

public class ShortCircuitAndOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 7;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ShortCircuitAndSyntaxTreeNode();
    }
}
