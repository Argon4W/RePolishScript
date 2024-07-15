package com.github.argon4w.rps.syntactic.nodes.operands;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushPlaceholderInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;

import java.util.List;
import java.util.Stack;

public class PushPlaceholderSyntaxTreeNode implements ISyntaxTreeNode {
    @Override
    public void popFromStack(Stack<ISyntaxTreeNode> stack) {

    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return List.of(new PushPlaceholderInstruction());
    }
}