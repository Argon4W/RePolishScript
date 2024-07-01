package com.github.argon4w.rps.lexical.tokens.operators.condition;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.condition.BiggerThanEqualsSyntaxTreeNode;

public class BiggerThanEqualsOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BiggerThanEqualsSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 12;
    }
}
