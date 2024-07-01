package com.github.argon4w.rps.lexical.tokens.operators.object;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.object.InSyntaxTreeNode;

public class InOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new InSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 18;
    }
}