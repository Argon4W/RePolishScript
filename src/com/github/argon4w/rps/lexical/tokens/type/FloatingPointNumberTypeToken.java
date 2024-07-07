package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushByteTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushFloatingPointNumberTypeSyntaxTreeNode;

public class PushFloatingPointNumberTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushFloatingPointNumberTypeSyntaxTreeNode();
    }
}