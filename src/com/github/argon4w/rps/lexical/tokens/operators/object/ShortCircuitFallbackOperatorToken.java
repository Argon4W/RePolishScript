package com.github.argon4w.rps.lexical.tokens.operators.object;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.object.ShortCircuitFallbackSyntaxTreeNode;

public class ShortCircuitFallbackOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ShortCircuitFallbackSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 7;
    }
}
