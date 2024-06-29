package com.github.argon4w.rpsh.runtime.instrutions.condition;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IComparableStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.BooleanStackValue;

public class SmallerThanEqualsInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof IComparableStackValue comparableLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new BooleanStackValue(comparableLeft.compare(right) <= 0));
        return false;
    }
}
