package com.github.argon4w.rpsh.lexical.tokens.operators.math;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.math.SubtractSyntaxTreeNode;

public class SubtractOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new SubtractSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 13;
    }
}
