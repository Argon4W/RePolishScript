package com.github.argon4w.rpsh.lexical.tokens.operators.logic;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.logic.ShortCircuitOrSyntaxTreeNode;

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
