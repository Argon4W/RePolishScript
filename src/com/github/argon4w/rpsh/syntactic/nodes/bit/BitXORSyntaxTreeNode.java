package com.github.argon4w.rpsh.syntactic.nodes.logic;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.logic.AndInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.logic.ShortCircuitAndInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rpsh.syntactic.nodes.stack.PushWrapperStackSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AndSyntaxTreeNode implements ISyntaxTreeNode {
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
        instructions.add(new AndInstruction());

        return instructions;
    }
}