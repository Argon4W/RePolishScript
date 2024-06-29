package com.github.argon4w.rpsh.lexical.tokens.operators.condition;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.condition.SmallerThanEqualsSyntaxTreeNode;

public class SmallerThanEqualsOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new SmallerThanEqualsSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 12;
    }
}
