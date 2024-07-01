package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushBooleanInstruction;

import java.util.List;

public class PushBooleanSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final boolean value;

    public PushBooleanSyntaxTreeNode(boolean value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new PushBooleanInstruction(value));
    }
}
