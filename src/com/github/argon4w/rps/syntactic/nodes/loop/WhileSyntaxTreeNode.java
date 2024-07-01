package com.github.argon4w.rps.syntactic.nodes.loop;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.loop.WhileInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.stack.PushWrapperStackSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WhileSyntaxTreeNode implements ISyntaxTreeNode {
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
        instructions.addAll(right.getInstructions());
        instructions.add(new WhileInstruction());

        return instructions;
    }
}
