package com.github.argon4w.rps.runtime.instrutions;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.BooleanStackValue;

public class IsInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(right instanceof ITypeStackValue typeRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(new BooleanStackValue(typeRight.is(left)));
        return false;
    }
}
