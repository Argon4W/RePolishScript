package com.github.argon4w.rps.lexical.tokens.operators.math;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.math.DivideSyntaxTreeNode;

public class DivideOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new DivideSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 15;
    }
}
