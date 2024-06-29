package com.github.argon4w.rpsh.runtime.instrutions.object;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;

public class ReferenceInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof NameStackValue nameRight)) {
            throw new IllegalStateException("Illegal reference");
        }

        stack.push(nameRight.getValue());
        return false;
    }
}