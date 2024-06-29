package com.github.argon4w.rpsh.syntactic.nodes.operands;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.operands.PushUndefinedInstruction;

import java.util.List;

public class PushUndefinedSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new PushUndefinedInstruction());
    }
}
