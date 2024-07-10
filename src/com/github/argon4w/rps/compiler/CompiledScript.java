package com.github.argon4w.rps.compiler;

import java.io.Serializable;

public record CompiledScript(CompiledStack[] compiledStacks, int rootStack) implements Serializable {
    public CompiledStack getRootStack() {
        return compiledStacks[rootStack];
    }

    public CompiledStack getStack(int index) {
        return compiledStacks[index];
    }
}
