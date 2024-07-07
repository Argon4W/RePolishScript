 package com.github.argon4w.rps.syntactic.nodes.operands.type;

import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushStringTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushWideCharacterTypeInstruction;

 public class PushWideCharacterTypeSyntaxTreeNode extends AbstractPushTypeSyntaxTreeNode {
    @Override
    public AbstractPushTypeInstruction getTypeInstruction() {
        return new PushWideCharacterTypeInstruction();
    }
}
