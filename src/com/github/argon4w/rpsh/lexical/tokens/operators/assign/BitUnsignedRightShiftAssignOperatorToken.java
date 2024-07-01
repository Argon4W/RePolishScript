package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.BitRightShiftAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.bit.BitLeftShiftSyntaxTreeNode;

public class BitRightShiftAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitRightShiftAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
