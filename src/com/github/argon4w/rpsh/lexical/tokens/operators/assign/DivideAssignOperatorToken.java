package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.MultiplyAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.SubtractAssignSyntaxTreeNode;

public class MultiplyAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new MultiplyAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
