package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushUndefinedInstruction;

import java.util.List;

public class PushUndefinedSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return List.of(new PushUndefinedInstruction());
    }
}
