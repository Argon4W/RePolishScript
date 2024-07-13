package com.github.argon4w.rps.compiler;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;

public record CompiledStack(IInstruction[] instructions) {
}
