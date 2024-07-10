package com.github.argon4w.rps.syntactic.nodes.stack;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushEmptyValueInstruction;
import com.github.argon4w.rps.runtime.instrutions.operands.PushIntegerNumberInstruction;
import com.github.argon4w.rps.runtime.instrutions.stack.PushExpressionStackInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.operands.AbstractOperandSyntaxTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PushExpressionStackSyntaxTreeNode extends AbstractOperandSyntaxTreeNode {
    public final List<ISyntaxTreeNode> topLevelSyntaxTreeNodes;

    public PushExpressionStackSyntaxTreeNode(List<ISyntaxTreeNode> topLevelSyntaxTreeNodes) {
        this.topLevelSyntaxTreeNodes = topLevelSyntaxTreeNodes;
    }

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        if (topLevelSyntaxTreeNodes.isEmpty()) {
            return List.of(new PushEmptyValueInstruction());
        }

        List<IInstruction> instructions = new ArrayList<>();

        instructions.add(new PushIntegerNumberInstruction(compiler.compileStack(topLevelSyntaxTreeNodes)));
        instructions.add(new PushExpressionStackInstruction());

        return instructions;
    }
}
