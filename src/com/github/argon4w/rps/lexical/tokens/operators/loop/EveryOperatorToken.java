package com.github.argon4w.rps.lexical.tokens.operators.loop;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.loop.EverySyntaxTreeNode;

public class EveryOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new EverySyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
