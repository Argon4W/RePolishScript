package com.github.argon4w.rpsh.syntactic.nodes.condition;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.condition.IfInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.stack.PushStackSyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.stack.PushWrapperStackSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IfSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode left;
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
        left = stack.pop();
    }

    @Override
    public List<IInstruction> getInstructions() {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(new PushWrapperStackSyntaxTreeNode(List.of(left)).getInstructions());
        instructions.addAll(new PushStackSyntaxTreeNode(List.of(right)).getInstructions());
        instructions.add(new IfInstruction());

        return instructions;
    }
}
