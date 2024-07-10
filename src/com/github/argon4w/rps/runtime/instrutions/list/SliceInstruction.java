package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ListStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IStringStackValue;
import com.github.argon4w.rps.runtime.valuess.slice.ListSliceStackValue;
import com.github.argon4w.rps.runtime.valuess.slice.StringSliceStackValue;

public class SliceInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (right instanceof IStringStackValue stringRight) {
            stack.push(new StringSliceStackValue(stringRight.codePoints()));
            return false;
        }

        if (right instanceof ListStackValue listRight) {
            stack.push(new ListSliceStackValue(listRight.values));
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }
}
