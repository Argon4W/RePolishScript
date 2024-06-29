package com.github.argon4w.rpsh.runtime.instrutions.list;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rpsh.runtime.values.slice.ListSliceStackValue;
import com.github.argon4w.rpsh.runtime.values.slice.StringSliceStackValue;

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
