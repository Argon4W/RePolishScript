package com.github.argon4w.rpsh.lexical.tokens.operators;

import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.DelimiterSyntaxTreeNode;

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
