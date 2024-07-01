package com.github.argon4w.rps.lexical.tokens;

import com.github.argon4w.rps.lexical.IToken;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.PushDoubleQuotedStringSyntaxTreeNode;

public record DoubleQuotedStringToken(String content) implements IToken {
    @Override
    public ISyntaxTreeNode getSyntaxTreeNode() {
        return new PushDoubleQuotedStringSyntaxTreeNode(content);
    }
}