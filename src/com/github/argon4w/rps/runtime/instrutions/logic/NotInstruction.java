package com.github.argon4w.rps.runtime.instrutions.logic;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.BooleanStackValue;

public class NotInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReversed();

        if (!(right instanceof BooleanStackValue booleanRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(new BooleanStackValue(!booleanRight.value()));

        return false;
    }
}
