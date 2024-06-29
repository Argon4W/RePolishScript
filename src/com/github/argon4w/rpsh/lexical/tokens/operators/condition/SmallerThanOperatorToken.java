package com.github.argon4w.rpsh.lexical.tokens.operators.condition;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.condition.SmallerThanSyntaxTreeNode;

public class SmallerThanOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new SmallerThanSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 12;
    }
}
