package com.github.argon4w.rps.syntactic.nodes.logic;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.logic.ShortCircuitAndInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.stack.PushWrapperStackSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortCircuitAndSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode left;
    public ISyntaxTreeNode right;

    public ShortCircuitAndSyntaxTreeNode() {

    }

    public ShortCircuitAndSyntaxTreeNode(ISyntaxTreeNode left, ISyntaxTreeNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
        left = stack.pop();
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(new PushWrapperStackSyntaxTreeNode(List.of(left)).compile(compiler));
        instructions.addAll(new PushWrapperStackSyntaxTreeNode(List.of(right)).compile(compiler));
        instructions.add(new ShortCircuitAndInstruction());

        return instructions;
    }
}
