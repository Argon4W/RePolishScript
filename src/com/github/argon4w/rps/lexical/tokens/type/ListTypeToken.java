package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushIntegerTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushListTypeSyntaxTreeNode;

public class PushListTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushListTypeSyntaxTreeNode();
    }
}
