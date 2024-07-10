package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushFloatingPointNumberInstruction;

import java.util.List;

public class PushFloatingNumberSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final double value;

    public PushFloatingNumberSyntaxTreeNode(double value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return List.of(new PushFloatingPointNumberInstruction(value));
    }
}
