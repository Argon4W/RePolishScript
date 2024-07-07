package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushNumberTypeSyntaxTreeNode;

public class NumberTypeToken extends AbstractTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushNumberTypeSyntaxTreeNode();
    }
}
