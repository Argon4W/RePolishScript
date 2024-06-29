package com.github.argon4w.rpsh.runtime.instrutions.condition;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IEquatableStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.BooleanStackValue;

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
