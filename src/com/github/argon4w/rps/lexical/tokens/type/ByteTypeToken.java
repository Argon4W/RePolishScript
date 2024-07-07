package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushByteTypeSyntaxTreeNode;

public class ByteTypeToken extends AbstractTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushByteTypeSyntaxTreeNode();
    }
}
