package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushListTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushNumberTypeSyntaxTreeNode;

public class PushNumberTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushNumberTypeSyntaxTreeNode();
    }
}
