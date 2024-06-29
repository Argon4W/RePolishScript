package com.github.argon4w.rpsh.runtime.instrutions.object;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.ReturnStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

public class ReturnInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new ReturnStackValue(stack.empty() ? new UndefinedStackValue() : stack.pop()));
        return true;
    }
}
