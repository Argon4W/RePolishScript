package com.github.argon4w.rpsh.lexical.tokens;

import com.github.argon4w.rpsh.lexical.IToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.operands.PushUndefinedSyntaxTreeNode;

public class UndefinedToken implements IToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new PushUndefinedSyntaxTreeNode();
    }
}
