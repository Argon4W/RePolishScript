package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;

public class LenInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof IListStackValue listRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(new IntegerStackValue(listRight.size()));
        return false;
    }
}
