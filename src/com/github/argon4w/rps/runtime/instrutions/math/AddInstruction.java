package com.github.argon4w.rps.runtime.instrutions.math;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IAddableStackValue;

public class AddInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof IAddableStackValue addableLeft)) {
            System.out.println(left);
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(addableLeft.add(right));
        return false;
    }
}
