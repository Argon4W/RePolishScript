package com.github.argon4w.rps.syntactic.nodes;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.IsInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode left;
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
        left = stack.pop();
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(left.compile(compiler));
        instructions.addAll(right.compile(compiler));
        instructions.add(new IsInstruction());

        return instructions;
    }
}
