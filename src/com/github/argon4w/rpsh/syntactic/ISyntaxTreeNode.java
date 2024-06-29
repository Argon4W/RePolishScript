package com.github.argon4w.rpsh.syntactic;

import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;

import java.util.List;
import java.util.Stack;

public interface ISyntaxTreeNode {
    void popFromStack(Stack<ISyntaxTreeNode> stack);
    List<IInstruction> getInstructions();
}
