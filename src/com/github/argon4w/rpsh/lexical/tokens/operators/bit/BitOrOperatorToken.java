package com.github.argon4w.rpsh.lexical.tokens.operators.logic;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.logic.OrSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.logic.ShortCircuitAndSyntaxTreeNode;

public class OrOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 8;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new OrSyntaxTreeNode();
    }
}
