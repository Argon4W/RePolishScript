package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.BitOrAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.BitXORAssignSyntaxTreeNode;

public class BitXORAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitXORAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
