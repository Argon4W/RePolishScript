package com.github.argon4w.rps.runtime.instrutions.object;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.ReturnStackValue;
import com.github.argon4w.rps.runtime.values.primitive.UndefinedStackValue;

public class ReturnInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new ReturnStackValue(stack.empty() ? new UndefinedStackValue() : stack.pop()));
        return true;
    }
}
