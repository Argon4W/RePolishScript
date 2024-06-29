package com.github.argon4w.rpsh.syntactic.nodes;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public class PushSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
    }

    @Override
    public List<IInstruction> getInstructions() {
        return right.getInstructions();
    }
}
