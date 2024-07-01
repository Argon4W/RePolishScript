package com.github.argon4w.rps.lexical.tokens.operators.list;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.list.LenSyntaxTreeNode;

public class LenOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new LenSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 19;
    }
}
