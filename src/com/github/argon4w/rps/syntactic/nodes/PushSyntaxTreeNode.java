package com.github.argon4w.rps.syntactic.nodes;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public class PushSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return right.compile(compiler);
    }
}
