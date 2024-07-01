package com.github.argon4w.rps.lexical.tokens.operators.math;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.math.AddSyntaxTreeNode;

public class AddOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new AddSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 14;
    }
}
