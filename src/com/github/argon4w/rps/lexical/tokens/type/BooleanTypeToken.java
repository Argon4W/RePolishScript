package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushBooleanTypeSyntaxTreeNode;

public class BooleanTypeToken extends AbstractTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushBooleanTypeSyntaxTreeNode();
    }
}
