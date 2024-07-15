package com.github.argon4w.rps.syntactic.nodes.list;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.list.OpenRangeEdgeInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OpenRangeEdgeSyntaxTreeNode implements ISyntaxTreeNode {
    public ISyntaxTreeNode right;

    public OpenRangeEdgeSyntaxTreeNode() {

    }

    public OpenRangeEdgeSyntaxTreeNode(ISyntaxTreeNode right) {
        this.right = right;
    }

    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {
        right = stack.pop();
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        List<IInstruction> instructions = new ArrayList<>();

        instructions.addAll(right.compile(compiler));
        instructions.add(new OpenRangeEdgeInstruction());

        return instructions;
    }
}
