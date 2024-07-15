package com.github.argon4w.rps.lexical.tokens.operators.assign;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.assign.FallbackAssignSyntaxTreeNode;

public class FallbackAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new FallbackAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
