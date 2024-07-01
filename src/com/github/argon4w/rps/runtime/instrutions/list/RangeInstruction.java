package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.values.primitive.SimpleRangeStackValue;

public class RangeInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(right instanceof IntegerStackValue integerRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        if (!(left instanceof IntegerStackValue integerLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new SimpleRangeStackValue(integerLeft.value(), integerRight.value()));
        return false;
    }
}
