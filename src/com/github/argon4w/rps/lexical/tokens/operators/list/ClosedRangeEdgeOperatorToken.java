package com.github.argon4w.rps.lexical.tokens.operators.list;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.list.ClosedRangeEdgeSyntaxTreeNode;

public class ClosedRangeEdgeOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 20;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ClosedRangeEdgeSyntaxTreeNode();
    }
}
