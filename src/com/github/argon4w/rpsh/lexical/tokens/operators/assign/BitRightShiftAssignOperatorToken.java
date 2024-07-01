package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.BitXORAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.bit.BitLeftShiftSyntaxTreeNode;

public class BitLeftShiftAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitLeftShiftSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
