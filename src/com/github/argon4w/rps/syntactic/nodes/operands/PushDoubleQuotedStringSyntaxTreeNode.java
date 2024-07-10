package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushDoubleQuotedStringInstruction;

import java.util.List;

public class PushDoubleQuotedStringSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final String value;

    public PushDoubleQuotedStringSyntaxTreeNode(String value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return List.of(new PushDoubleQuotedStringInstruction(value));
    }
}
