package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushSingleQuotedStringInstruction;

import java.util.List;

public class PushSingleQuotedStringSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final String value;

    public PushSingleQuotedStringSyntaxTreeNode(String value) {
        this.value = value;
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return List.of(new PushSingleQuotedStringInstruction(value));
    }
}
