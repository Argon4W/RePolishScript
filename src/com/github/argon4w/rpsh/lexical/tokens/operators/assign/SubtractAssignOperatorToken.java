package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.AddAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.AssignSyntaxTreeNode;

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
