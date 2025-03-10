package com.github.argon4w.rps.lexical.tokens.operators.condition;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.condition.BiggerThanSyntaxTreeNode;

public class BiggerThanOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BiggerThanSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 12;
    }
}
