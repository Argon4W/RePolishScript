package com.github.argon4w.rps.lexical.tokens.operators.assign;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.assign.DivideAssignSyntaxTreeNode;

public class DivideAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new DivideAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
