package com.github.argon4w.rps.runtime.instrutions.operands;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.primitive.UndefinedStackValue;

public class PushUndefinedInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new UndefinedStackValue());
        return false;
    }
}
