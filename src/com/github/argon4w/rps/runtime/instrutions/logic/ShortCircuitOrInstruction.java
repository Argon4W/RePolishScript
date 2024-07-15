package com.github.argon4w.rps.runtime.instrutions.logic;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.BooleanStackValue;

public class ShortCircuitOrInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReserved();
        IStackValue left = stack.popReserved();

        if (!(right instanceof RuntimeWrapperStack stackRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        if (!(left instanceof RuntimeWrapperStack stackLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stackLeft.invoke();

        if (stackLeft.popBooleanResult()) {
            stack.push(new BooleanStackValue(true));
            return false;
        }

        stackRight.invoke();
        stack.push(new BooleanStackValue(stackRight.popBooleanResult()));
        return false;
    }
}
