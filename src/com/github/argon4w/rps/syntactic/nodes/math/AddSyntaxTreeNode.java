package com.github.argon4w.rps.syntactic.nodes.math;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.math.AddInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddSyntaxTreeNode implements ISyntaxTreeNode {
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

        instructions.addAll(left.getInstructions());
        instructions.addAll(right.getInstructions());
        instructions.add(new AddInstruction());

        return instructions;
    }
}