package com.github.argon4w.rpsh.syntactic.nodes.object;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.object.ReturnInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReturnSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
    }

    @Override
    public List<IInstruction> getInstructions() {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(right.getInstructions());
        instructions.add(new ReturnInstruction());

        return instructions;
    }
}
