package com.github.argon4w.rps.syntactic;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;

import java.util.List;
import java.util.Stack;

public class StackFenceSyntaxTreeNode implements ISyntaxTreeNode {
    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        throw new IllegalStateException("Illegal operation");
    }
}
