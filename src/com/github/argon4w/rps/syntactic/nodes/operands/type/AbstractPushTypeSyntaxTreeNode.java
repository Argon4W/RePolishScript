package com.github.argon4w.rps.syntactic.nodes.operands.type;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.type.AbstractPushTypeInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public abstract class AbstractPushTypeSyntaxTreeNode implements ISyntaxTreeNode {
    public abstract AbstractPushTypeInstruction getTypeInstruction();

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {

    }

    @Override
    public List<IInstruction> getInstructions() {
        return List.of(getTypeInstruction());
    }
}
