package com.github.argon4w.rpsh.lexical.tokens.operators.logic;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.logic.AndSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.logic.ShortCircuitAndSyntaxTreeNode;

public class AndOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new AndSyntaxTreeNode();
    }
}
