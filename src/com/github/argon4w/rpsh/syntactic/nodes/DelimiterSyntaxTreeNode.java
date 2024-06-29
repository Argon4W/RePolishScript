package com.github.argon4w.rpsh.syntactic.nodes;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public class DelimiterSyntaxTreeNode implements ISyntaxTreeNode {
    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {

    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of();
    }
}
