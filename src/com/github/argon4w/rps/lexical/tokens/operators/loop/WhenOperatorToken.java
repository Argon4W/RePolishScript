package com.github.argon4w.rps.lexical.tokens.operators.loop;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.loop.WhenSyntaxTreeNode;

public class WhenOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new WhenSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
