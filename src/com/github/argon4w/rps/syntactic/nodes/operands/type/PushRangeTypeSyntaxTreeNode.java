 package com.github.argon4w.rps.syntactic.nodes.operands.type;

import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushNumberTypeInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.PushRangeTypeInstruction;

 public class PushRangeTypeSyntaxTreeNode extends AbstractPushTypeSyntaxTreeNode {
    @Override
    public AbstractPushTypeInstruction getTypeInstruction() {
        return new PushRangeTypeInstruction();
    }
}
