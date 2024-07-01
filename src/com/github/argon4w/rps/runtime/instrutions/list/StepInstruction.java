package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.values.primitive.SimpleRangeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.SteppedRangeStackValue;

public class StepInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(right instanceof IntegerStackValue integerRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        if (!(left instanceof SimpleRangeStackValue rangeLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new SteppedRangeStackValue(rangeLeft.start(), rangeLeft.end(), integerRight.value()));
        return false;
    }
}
