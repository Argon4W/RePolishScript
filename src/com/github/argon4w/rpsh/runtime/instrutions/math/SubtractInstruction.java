package com.github.argon4w.rpsh.runtime.instrutions.math;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.INumericStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

public class SubtractInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof INumericStackValue numericLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(numericLeft.subtract(right));
        return false;
    }
}
