package com.github.argon4w.rps.syntactic.nodes.operands.type;

import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushByteTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushFloatingPointNumberTypeInstruction;

public class PushFloatingPointNumberTypeSyntaxTreeNode extends AbstractPushTypeSyntaxTreeNode {
    @Override
    public AbstractPushTypeInstruction getTypeInstruction() {
        return new PushFloatingPointNumberTypeInstruction();
    }
}
