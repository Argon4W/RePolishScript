package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushNumberTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushRangeTypeSyntaxTreeNode;

public class PushRangeTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushRangeTypeSyntaxTreeNode();
    }
}
