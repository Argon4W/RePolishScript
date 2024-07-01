package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.BitAndAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.ModAssignSyntaxTreeNode;

public class BitAndAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new BitAndAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}