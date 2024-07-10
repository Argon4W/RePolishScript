package com.github.argon4w.rps.runtime.instrutions.stack;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;

public class PushArrayStackInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof IntegerStackValue integerRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(stack.runtime.requestArrayStack(stack, (int) integerRight.value()));
        return false;
    }
}
