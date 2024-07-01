package com.github.argon4w.rps.lexical.tokens.operators.bit;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.bit.BitXORSyntaxTreeNode;

public class BitNotOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 16;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitXORSyntaxTreeNode();
    }
}
