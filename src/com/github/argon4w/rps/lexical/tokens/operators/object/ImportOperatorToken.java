package com.github.argon4w.rps.lexical.tokens.operators.object;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.object.ImportSyntaxTreeNode;

public class ImportOperatorToken implements IOperatorToken {
    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new ImportSyntaxTreeNode();
    }
}
