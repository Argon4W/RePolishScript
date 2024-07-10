package com.github.argon4w.rps.runtime.instrutions.math;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IMultiplierStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

public class MultiplyInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof IMultiplierStackValue multiplierLef)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(multiplierLef.multiply(right));
        return false;
    }
}
