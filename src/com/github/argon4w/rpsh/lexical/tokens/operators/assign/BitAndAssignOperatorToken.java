package com.github.argon4w.rpsh.lexical.tokens.operators.assign;

import com.github.argon4w.rpsh.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.ModAssignSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.assign.MultiplyAssignSyntaxTreeNode;

public class ModAssignOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ModAssignSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
