package com.github.argon4w.rpsh.lexical.tokens.operators.loop;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.loop.ContinueSyntaxTreeNode;

public class ContinueOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ContinueSyntaxTreeNode();
    }
}
