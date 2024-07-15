package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.SimpleRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.SteppedRangeStackValue;

public class StepInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof SimpleRangeStackValue rangeLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (!rangeLeft.canBeStepped()) {
            throw new IllegalStateException("Illegal left components");
        }

        if (right instanceof INumericStackValue numericRight) {
            stack.push(new SteppedRangeStackValue(rangeLeft.start(), rangeLeft.end(), numericRight));
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }
}
