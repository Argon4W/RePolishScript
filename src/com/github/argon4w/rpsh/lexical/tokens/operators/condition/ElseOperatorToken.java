package com.github.argon4w.rpsh.lexical.tokens.operators.condition;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.condition.ElseSyntaxTreeNode;

public class ElseOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ElseSyntaxTreeNode();
    }
}
