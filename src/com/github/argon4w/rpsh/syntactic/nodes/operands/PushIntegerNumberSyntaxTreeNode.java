package com.github.argon4w.rpsh.syntactic.nodes.operands;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.operands.PushIntegerNumberInstruction;

import java.util.List;

public class PushIntegerNumberSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final long value;

    public PushIntegerNumberSyntaxTreeNode(long value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new PushIntegerNumberInstruction(value));
    }
}
