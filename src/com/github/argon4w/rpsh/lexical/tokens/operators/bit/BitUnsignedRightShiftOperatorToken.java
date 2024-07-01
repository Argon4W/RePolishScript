package com.github.argon4w.rpsh.lexical.tokens.operators.bit;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.bit.BitLeftShiftSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.bit.BitRightShiftSyntaxTreeNode;

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
