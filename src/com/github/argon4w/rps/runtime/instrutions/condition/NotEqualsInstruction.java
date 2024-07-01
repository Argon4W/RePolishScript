package com.github.argon4w.rps.runtime.instrutions.condition;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.BooleanStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IEquatableStackValue;

public class NotEqualsInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof IEquatableStackValue equatableLeft)) {
            stack.push(new BooleanStackValue(!left.equals(right)));
            return false;
        }

        stack.push(new BooleanStackValue(!equatableLeft.equals(right)));
        return false;
    }
}
