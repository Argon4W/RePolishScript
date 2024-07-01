package com.github.argon4w.rps.lexical.tokens.operators.condition;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.condition.ElseSyntaxTreeNode;

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
