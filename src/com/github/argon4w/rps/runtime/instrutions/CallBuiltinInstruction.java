package com.github.argon4w.rps.runtime.instrutions;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IStringStackValue;

public class CallBuiltinInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (right instanceof IStringStackValue stringRight) {
            stack.runtimeBuiltinFunctions.invokeFunction(stringRight.value(), stack);
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }
}
