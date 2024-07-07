package com.github.argon4w.rps.syntactic.nodes.operands.type;

import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushFloatingPointNumberTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushFunctionTypeInstruction;

public class PushFunctionTypeSyntaxTreeNode extends AbstractPushTypeSyntaxTreeNode {
    @Override
    public AbstractPushTypeInstruction getTypeInstruction() {
        return new PushFunctionTypeInstruction();
    }
}
