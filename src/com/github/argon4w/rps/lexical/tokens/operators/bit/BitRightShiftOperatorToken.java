package com.github.argon4w.rps.lexical.tokens.operators.bit;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.bit.BitRightShiftSyntaxTreeNode;

public class BitRightShiftOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 13;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitRightShiftSyntaxTreeNode();
    }
}
