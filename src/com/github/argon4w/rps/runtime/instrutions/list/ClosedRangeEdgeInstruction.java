package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.ClosedRangeEdgeStackValue;

public class ClosedRangeEdgeInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof INumericStackValue numericRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(new ClosedRangeEdgeStackValue(numericRight));
        return false;
    }
}
