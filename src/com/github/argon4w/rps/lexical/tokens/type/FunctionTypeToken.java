package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushFloatingPointNumberTypeSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.type.PushFunctionTypeSyntaxTreeNode;

public class PushFunctionTypeToken extends AbstractPushTypeToken {
    @Override
    public AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode() {
        return new PushFunctionTypeSyntaxTreeNode();
    }
}
