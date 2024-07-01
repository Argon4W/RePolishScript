package com.github.argon4w.rps.lexical.tokens.operators;

import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.DelimiterSyntaxTreeNode;

public class DelimiterOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new DelimiterSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
