package com.github.argon4w.rps.lexical.tokens.operators.loop;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.loop.BreakSyntaxTreeNode;

public class BreakOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BreakSyntaxTreeNode();
    }
}
