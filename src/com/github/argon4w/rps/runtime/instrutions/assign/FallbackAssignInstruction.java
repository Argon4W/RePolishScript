package com.github.argon4w.rps.runtime.instrutions.assign;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IAddableStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.UndefinedStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.IReferencedStackValue;

public class FallbackAssignInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReserved();

        if (!(left instanceof IReferencedStackValue referenceLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (referenceLeft.value() instanceof UndefinedStackValue) {
            referenceLeft.setValue(right);
            stack.push(right);
            return false;
        }

        stack.push(left);
        return false;
    }
}
