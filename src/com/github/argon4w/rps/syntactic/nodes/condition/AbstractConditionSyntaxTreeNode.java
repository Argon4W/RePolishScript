package com.github.argon4w.rps.syntactic.nodes.condition;

import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.syntactic.ISyntaxTreeNode;
import com.github.argon4w.rps.syntactic.nodes.logic.ShortCircuitAndSyntaxTreeNode;

import java.util.List;

public abstract class AbstractConditionSyntaxTreeNode implements ISyntaxTreeNode {
    public abstract ISyntaxTreeNode getRightTreeNode();
    public abstract ISyntaxTreeNode getLeftTreeNode();
    public abstract ISyntaxTreeNode setLeftTreeNode(ISyntaxTreeNode treeNode);
    public abstract List<IInstruction> compileNonChained(RePolishCompiler compiler);

    @Override
    public List<IInstruction> compile(RePolishCompiler compiler) {
        return getLeftTreeNode() instanceof AbstractConditionSyntaxTreeNode conditionTreeNode ? new ShortCircuitAndSyntaxTreeNode(getLeftTreeNode(), setLeftTreeNode(conditionTreeNode.getRightTreeNode())).compile(compiler) : compileNonChained(compiler);
    }
}
