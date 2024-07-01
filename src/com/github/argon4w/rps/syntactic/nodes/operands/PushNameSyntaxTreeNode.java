package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushNameInstruction;

import java.util.List;

public class PushNameSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final String value;

    public PushNameSyntaxTreeNode(String value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new PushNameInstruction(value));
    }
}
