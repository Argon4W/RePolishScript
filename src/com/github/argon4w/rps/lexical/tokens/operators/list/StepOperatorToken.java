package com.github.argon4w.rps.lexical.tokens.operators.list;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.list.StepSyntaxTreeNode;

public class StepOperatorToken implements IOperatorToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new StepSyntaxTreeNode();
    }

    @Override
    public int getPriority() {
        return 19;
    }
}
