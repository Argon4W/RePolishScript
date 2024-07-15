package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.ClosedRangeEdgeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.IRangeEdgeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.OpenRangeEdgeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.SimpleRangeStackValue;

public class RangeInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (right instanceof INumericStackValue numericRight) {
            if (left instanceof INumericStackValue numericLeft) {
                stack.push(new SimpleRangeStackValue(new ClosedRangeEdgeStackValue(numericLeft), new OpenRangeEdgeStackValue(numericRight)));
                return false;
            }

            if (left instanceof IRangeEdgeStackValue rangeEdgeLeft) {
                stack.push(new SimpleRangeStackValue(rangeEdgeLeft, new OpenRangeEdgeStackValue(numericRight)));
                return false;
            }

            throw new IllegalStateException("Illegal left components");
        }

        if (right instanceof IRangeEdgeStackValue rangeEdgeRight) {
            if (left instanceof INumericStackValue numericLeft) {
                stack.push(new SimpleRangeStackValue(new ClosedRangeEdgeStackValue(numericLeft), rangeEdgeRight));
                return false;
            }

            if (left instanceof IRangeEdgeStackValue rangeEdgeLeft) {
                stack.push(new SimpleRangeStackValue(rangeEdgeLeft, rangeEdgeRight));
                return false;
            }

            throw new IllegalStateException("Illegal left components");
        }

        throw new IllegalStateException("Illegal right components");
    }
}
