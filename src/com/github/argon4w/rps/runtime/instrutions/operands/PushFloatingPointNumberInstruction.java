package com.github.argon4w.rps.runtime.instrutions.operands;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.primitive.FloatingPointNumberStackValue;

public record PushFloatingPointNumberInstruction(double value) implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new FloatingPointNumberStackValue(value));
        return false;
    }
}
