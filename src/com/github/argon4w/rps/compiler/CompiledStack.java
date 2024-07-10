package com.github.argon4w.rps.compiler;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;

import java.util.Arrays;
import java.util.List;

public record CompiledStack(IInstruction[] instructions) {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof CompiledStack compiledStack && Arrays.equals(compiledStack.instructions, instructions);
    }
}
