package com.github.argon4w.rps.syntactic.nodes.stack;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.stack.PopStackInstruction;
import com.github.argon4w.rps.runtime.instrutions.stack.PushStackInstructionInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.AbstractOperandSyntaxTreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PushStackSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final List<ISyntaxTreeNode> topLevelSyntaxTreeNodes;

    public PushStackSyntaxTreeNode(List<ISyntaxTreeNode> topLevelSyntaxTreeNodes) {
        this.topLevelSyntaxTreeNodes = topLevelSyntaxTreeNodes;
    }

    @Override
    public List<IInstruction> getInstructions() {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(topLevelSyntaxTreeNodes.stream().map(ISyntaxTreeNode::getInstructions).flatMap(Collection::stream).map(PushStackInstructionInstruction::new).toList());
        instructions.add(new PopStackInstruction());

        return instructions;
    }
}