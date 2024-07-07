package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushFunctionTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushIntegerTypeSyntaxTreeNode;

public class PushIntegerTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushIntegerTypeSyntaxTreeNode();
    }
}
