package com.github.argon4w.rps.lexical.tokens.operators.assign;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.assign.ShortCircuitFallbackAssignSyntaxTreeNode;

public class ShortCircuitFallbackAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ShortCircuitFallbackAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
