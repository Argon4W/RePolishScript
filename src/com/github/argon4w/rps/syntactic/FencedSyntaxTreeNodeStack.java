package com.github.argon4w.rps.syntactic;

import com.github.argon4w.rps.lexical.tokens.operators.IOperatorToken;

import java.util.HashMap;
import java.util.Stack;

public class FencedSyntaxTreeNodeStack extends Stack<ISyntaxTreeNode> {
    public final HashMap<IOperatorToken, Integer> fenceIndices;

    public FencedSyntaxTreeNodeStack() {
        this.fenceIndices = new HashMap<>();
    }

    public void setOperatorTokenFence(IOperatorToken token) {
        if (fenceIndices.containsKey(token)) {
            throw new IllegalStateException("Illegal duplicated token");
        }

        push(new StackFenceSyntaxTreeNode());
        fenceIndices.put(token, size() - 1);
    }

    public void resetOperatorTokenFence(IOperatorToken token) {
        if (!fenceIndices.containsKey(token)) {
            throw new IllegalStateException("Illegal token");
        }

        remove(fenceIndices.get(token).intValue());
        fenceIndices.remove(token);
    }

    @Override
    public synchronized ISyntaxTreeNode pop() {
        if (peek() instanceof StackFenceSyntaxTreeNode) {
            throw new IllegalStateException("Illegal operation");
        }

        return super.pop();
    }

    @Override
    public boolean empty() {
        return super.empty() || peek() instanceof StackFenceSyntaxTreeNode;
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty() || peek() instanceof StackFenceSyntaxTreeNode;
    }
}
