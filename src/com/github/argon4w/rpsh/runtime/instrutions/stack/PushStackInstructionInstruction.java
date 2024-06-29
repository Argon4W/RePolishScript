package com.github.argon4w.rpsh.runtime.instrutions.stack;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;

public record PushStackInstructionInstruction(IInstruction instruction) implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.addStackInstructions(instruction);
        return false;
    }
}
