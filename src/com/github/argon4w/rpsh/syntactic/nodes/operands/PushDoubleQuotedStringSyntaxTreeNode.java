package com.github.argon4w.rpsh.syntactic.nodes.operands;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.operands.PushDoubleQuotedStringInstruction;

import java.util.List;

public class PushDoubleQuotedStringSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final String value;

    public PushDoubleQuotedStringSyntaxTreeNode(String value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new PushDoubleQuotedStringInstruction(value));
    }
}
