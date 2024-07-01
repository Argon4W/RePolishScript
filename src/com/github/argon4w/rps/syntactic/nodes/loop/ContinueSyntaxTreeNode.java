package com.github.argon4w.rps.syntactic.nodes.loop;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.loop.ContinueInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public class ContinueSyntaxTreeNode implements ISyntaxTreeNode {

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {

    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(new ContinueInstruction());
    }
}
