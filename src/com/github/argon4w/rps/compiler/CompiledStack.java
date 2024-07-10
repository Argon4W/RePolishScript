package com.github.argon4w.rps.compiler;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;

import java.io.Serializable;
import java.util.Arrays;

public record CompiledStack(IInstruction[] instructions) implements Serializable {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof CompiledStack compiledStack && Arrays.equals(compiledStack.instructions, instructions);
    }
}
