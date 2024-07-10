package com.github.argon4w.rps.syntactic.nodes.stack;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushEmptyListInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushIntegerNumberInstruction;
import com.github.argon4w.rps.runtime.instrutions.stack.PushArrayStackInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.AbstractOperandSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PushArrayStackSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final List<ISyntaxTreeNode> topLevelSyntaxTreeNodes;

    public PushArrayStackSyntaxTreeNode(List<ISyntaxTreeNode> topLevelSyntaxTreeNodes) {
        this.topLevelSyntaxTreeNodes = topLevelSyntaxTreeNodes;
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        if (topLevelSyntaxTreeNodes.isEmpty()) {
            return List.of(new PushEmptyListInstruction());
        }

        List<IInstruction> instructions = new ArrayList<>();

        instructions.add(new PushIntegerNumberInstruction(compiler.compileStack(topLevelSyntaxTreeNodes)));
        instructions.add(new PushArrayStackInstruction());

        return instructions;
    }
}
