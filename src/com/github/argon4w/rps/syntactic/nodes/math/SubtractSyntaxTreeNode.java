package com.github.argon4w.rps.syntactic.nodes.math;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.math.SubtractInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.PushIntegerNumberSyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.PushPlaceholderSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubtractSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode left;
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
        left = stack.empty() ? new PushPlaceholderSyntaxTreeNode() : stack.pop();
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(left.compile(compiler));
        instructions.addAll(right.compile(compiler));
        instructions.add(new SubtractInstruction());

        return instructions;
    }
}
