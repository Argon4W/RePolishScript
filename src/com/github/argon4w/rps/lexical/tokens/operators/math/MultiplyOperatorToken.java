package com.github.argon4w.rps.lexical.tokens.operators.math;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.math.MultiplySyntaxTreeNode;

public class MultiplyOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new MultiplySyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 15;
    }
}
