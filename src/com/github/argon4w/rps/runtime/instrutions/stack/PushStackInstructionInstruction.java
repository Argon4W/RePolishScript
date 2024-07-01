package com.github.argon4w.rps.runtime.instrutions.stack;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;

public record PushStackInstructionInstruction(IInstruction instruction) implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.addStackInstructions(instruction);
        return false;
    }
}