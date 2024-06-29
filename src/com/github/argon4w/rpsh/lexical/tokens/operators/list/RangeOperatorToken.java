package com.github.argon4w.rpsh.lexical.tokens.operators.list;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.list.RangeSyntaxTreeNode;

public class RangeOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new RangeSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 17;
    }
}
