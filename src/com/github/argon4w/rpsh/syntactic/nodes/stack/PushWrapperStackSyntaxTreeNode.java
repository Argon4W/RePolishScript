package com.github.argon4w.rpsh.syntactic.nodes.stack;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.stack.PopWrapperStackInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.stack.PushStackInstructionInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.operands.AbstractOperandSyntaxTreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PushWrapperStackSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final List<ISyntaxTreeNode> topLevelSyntaxTreeNodes;

    public PushWrapperStackSyntaxTreeNode(List<ISyntaxTreeNode> topLevelSyntaxTreeNodes) {
        this.topLevelSyntaxTreeNodes = topLevelSyntaxTreeNodes;
    }

    @Override
    public List<IInstruction> getInstructions() {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(topLevelSyntaxTreeNodes.stream().map(ISyntaxTreeNode::getInstructions).flatMap(Collection::stream).map(PushStackInstructionInstruction::new).toList());
        instructions.add(new PopWrapperStackInstruction());

        return instructions;
    }
}
