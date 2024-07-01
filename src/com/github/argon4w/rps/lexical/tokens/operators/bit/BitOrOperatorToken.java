package com.github.argon4w.rps.lexical.tokens.operators.bit;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.bit.BitOrSyntaxTreeNode;

public class BitOrOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 8;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitOrSyntaxTreeNode();
    }
}
