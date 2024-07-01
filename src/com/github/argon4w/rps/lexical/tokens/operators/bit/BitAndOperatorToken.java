package com.github.argon4w.rps.lexical.tokens.operators.bit;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.bit.BitAndSyntaxTreeNode;

public class BitAndOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitAndSyntaxTreeNode();
    }
}
