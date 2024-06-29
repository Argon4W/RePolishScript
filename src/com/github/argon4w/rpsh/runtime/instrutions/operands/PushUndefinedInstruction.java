package com.github.argon4w.rpsh.runtime.instrutions.operands;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

public class PushUndefinedInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new UndefinedStackValue());
        return false;
    }
}
