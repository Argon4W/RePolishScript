package com.github.argon4w.rps.lexical.tokens.operators.object;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.object.OfSyntaxTreeNode;

public class OfOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new OfSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 22;
    }
}
