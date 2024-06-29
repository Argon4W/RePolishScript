package com.github.argon4w.rpsh.syntactic.nodes.logic;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.logic.ShortCircuitOrInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.stack.PushWrapperStackSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortCircuitOrSyntaxTreeNode implements ISyntaxTreeNode {
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
        instructions.addAll(new PushWrapperStackSyntaxTreeNode(List.of(right)).getInstructions());
        instructions.add(new ShortCircuitOrInstruction());

        return instructions;
    }
}
