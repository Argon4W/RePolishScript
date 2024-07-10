package com.github.argon4w.rps.runtime.instrutions.operands;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.primitive.BooleanStackValue;

public record PushBooleanInstruction(boolean value) implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new BooleanStackValue(value));
        return false;
    }
}
