package com.github.argon4w.rps.runtime.instrutions.assign;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.IReferencedStackValue;

public class ModAssignInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReserved();

        if (!(left instanceof IReferencedStackValue referenceLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        left = referenceLeft.value();

        if (!(left instanceof INumericStackValue numericLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        IStackValue result = numericLeft.mod(right);
        referenceLeft.setValue(result);
        stack.push(result);

        return false;
    }
}
