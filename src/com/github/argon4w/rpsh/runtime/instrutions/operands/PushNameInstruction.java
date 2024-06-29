package com.github.argon4w.rpsh.runtime.instrutions.operands;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;

public record PushNameInstruction(String value) implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new NameStackValue(value, stack));
        return false;
    }
}
