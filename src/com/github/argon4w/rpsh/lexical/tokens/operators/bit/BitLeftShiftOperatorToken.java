package com.github.argon4w.rpsh.lexical.tokens.operators.bit;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.bit.BitXORSyntaxTreeNode;

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
