package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushStackTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushStringTypeSyntaxTreeNode;

public class PushStringTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushStringTypeSyntaxTreeNode();
    }
}
