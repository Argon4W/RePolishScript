package com.github.argon4w.rps.syntactic.nodes.condition;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.condition.BiggerThanInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BiggerThanSyntaxTreeNode extends AbstractConditionSyntaxTreeNode {
    public ISyntaxTreeNode left;
    public ISyntaxTreeNode right;

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
        left = stack.pop();
    }

    @Override
    public List<IInstruction> compileNonChained(RePolishCompiler compiler) {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(left.compile(compiler));
        instructions.addAll(right.compile(compiler));
        instructions.add(new BiggerThanInstruction());

        return instructions;
    }

    @Override
    public ISyntaxTreeNode getRightTreeNode() {
        return right;
    }

    @Override
    public ISyntaxTreeNode getLeftTreeNode() {
        return left;
    }

    @Override
    public ISyntaxTreeNode setLeftTreeNode(ISyntaxTreeNode treeNode) {
        left = treeNode;
        return this;
    }
}
