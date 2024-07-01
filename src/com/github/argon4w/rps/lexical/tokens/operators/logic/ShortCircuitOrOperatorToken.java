package com.github.argon4w.rps.lexical.tokens.operators.logic;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.logic.ShortCircuitOrSyntaxTreeNode;

public class ShortCircuitOrOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ShortCircuitOrSyntaxTreeNode();
    }
}
