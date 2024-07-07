package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushRangeTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushStackTypeSyntaxTreeNode;

public class PushStackTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushStackTypeSyntaxTreeNode();
    }
}
