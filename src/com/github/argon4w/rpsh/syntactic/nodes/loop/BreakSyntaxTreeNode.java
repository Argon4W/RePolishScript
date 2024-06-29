package com.github.argon4w.rpsh.syntactic.nodes.loop;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.instrutions.loop.BreakInstruction;
import com.github.argon4w.rpsh.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public class BreakSyntaxTreeNode implements ISyntaxTreeNode {

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {

    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new BreakInstruction());
    }
}
