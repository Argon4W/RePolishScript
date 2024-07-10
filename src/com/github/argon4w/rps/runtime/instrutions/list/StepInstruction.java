package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ByteStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.SimpleRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.SteppedRangeStackValue;

public class StepInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof SimpleRangeStackValue rangeLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (right instanceof IntegerStackValue integerRight) {
            stack.push(new SteppedRangeStackValue(rangeLeft.start(), rangeLeft.end(), integerRight.value()));
            return false;
        }

        if (right instanceof ByteStackValue byteValue) {
            stack.push(new SteppedRangeStackValue(rangeLeft.start(), rangeLeft.end(), byteValue.value()));
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }
}
