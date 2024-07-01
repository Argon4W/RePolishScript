package com.github.argon4w.rps.runtime.instrutions.condition;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.BooleanStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IComparableStackValue;

public class BiggerThanInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof IComparableStackValue comparableLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new BooleanStackValue(comparableLeft.compare(right) > 0));
        return false;
    }
}
