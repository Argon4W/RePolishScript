package com.github.argon4w.rpsh.runtime.instrutions;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;

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
