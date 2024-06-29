package com.github.argon4w.rpsh.lexical.tokens;

import com.github.argon4w.rpsh.lexical.IToken;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.operands.PushBooleanSyntaxTreeNode;

public record BooleanToken(boolean content) implements IToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new PushBooleanSyntaxTreeNode(content);
    }
}
