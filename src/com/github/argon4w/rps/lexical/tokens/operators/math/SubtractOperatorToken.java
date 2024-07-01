package com.github.argon4w.rps.lexical.tokens.operators.math;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.math.SubtractSyntaxTreeNode;

public class SubtractOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new SubtractSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 14;
    }
}
