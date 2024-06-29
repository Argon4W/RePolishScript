package com.github.argon4w.rpsh.runtime.instrutions.operands;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.primitive.FloatingPointNumberStackValue;

public record PushFloatingPointNumberInstruction(double value) implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new FloatingPointNumberStackValue(value));
        return false;
    }
}
