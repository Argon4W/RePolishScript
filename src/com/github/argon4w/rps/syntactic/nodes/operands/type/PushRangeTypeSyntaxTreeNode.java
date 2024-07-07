package com.github.argon4w.rps.syntactic.nodes.operands.type;

import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushListTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushNumberTypeInstruction;

public class PushNumberTypeSyntaxTreeNode extends AbstractPushTypeSyntaxTreeNode {
    @Override
    public AbstractPushTypeInstruction getTypeInstruction() {
        return new PushNumberTypeInstruction();
    }
}