package com.github.argon4w.rps.compiler;

public record CompiledScript(CompiledStack[] compiledStacks, int rootStack) {
    public CompiledStack getRootStack() {
        return compiledStacks[rootStack];
    }

    public CompiledStack getStack(int index) {
        return compiledStacks[index];
    }
}
