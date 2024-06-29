package com.github.argon4w.rpsh.syntactic.nodes.operands;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.operands.PushFloatingPointNumberInstruction;

import java.util.List;

public class PushFloatingNumberSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final double value;

    public PushFloatingNumberSyntaxTreeNode(double value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new PushFloatingPointNumberInstruction(value));
    }
}
