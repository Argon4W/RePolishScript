package com.github.argon4w.rps.lexical.tokens.operators.assign;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.assign.AddAssignSyntaxTreeNode;

public class AddAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new AddAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
