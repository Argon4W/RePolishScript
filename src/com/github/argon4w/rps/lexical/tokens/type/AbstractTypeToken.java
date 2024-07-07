package com.github.argon4w.rps.lexical.tokens.type;

import com.github.argon4w.rps.lexical.IToken;
import com.github.argon4w.rps.syntactic.nodes.operands.type.AbstractPushTypeSyntaxTreeNode;

public abstract class AbstractTypeToken implements IToken {
    public abstract AbstractPushTypeSyntaxTreeNode getSyntaxTreeNode();
}
