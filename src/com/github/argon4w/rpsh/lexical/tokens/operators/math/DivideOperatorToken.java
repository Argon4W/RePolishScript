package com.github.argon4w.rpsh.lexical.tokens.operators.math;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.math.DivideSyntaxTreeNode;

public class DivideOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new DivideSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 14;
    }
}
