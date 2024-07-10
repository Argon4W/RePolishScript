package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushIntegerNumberInstruction;

import java.util.List;

public class PushIntegerNumberSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final long value;

    public PushIntegerNumberSyntaxTreeNode(long value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return List.of(new PushIntegerNumberInstruction(value));
    }
}
