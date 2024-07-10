 package com.github.argon4w.rps.syntactic.nodes.operands.type;

 import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
 import com.github.argon4w.rps.runtime.instrutions.operands.type.PushStringTypeInstruction;

 public class PushStringTypeSyntaxTreeNode extends AbstractPushTypeSyntaxTreeNode {
    @Override
    public AbstractPushTypeInstruction getTypeInstruction() {
        return new PushStringTypeInstruction();
    }
}
