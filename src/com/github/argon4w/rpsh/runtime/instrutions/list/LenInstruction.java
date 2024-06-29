package com.github.argon4w.rpsh.runtime.instrutions.list;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IntegerStackValue;

public class LenInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof ListStackValue listRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(new IntegerStackValue(listRight.values.size()));
        return false;
    }
}
