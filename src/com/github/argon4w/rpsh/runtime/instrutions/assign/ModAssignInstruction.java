package com.github.argon4w.rpsh.runtime.instrutions.assign;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IReferencedStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.INumericStackValue;

public class DivideAssignInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReversed();

        if (!(left instanceof IReferencedStackValue referenceLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        left = referenceLeft.value();

        if (!(left instanceof INumericStackValue numericLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        IStackValue result = numericLeft.divide(right);
        referenceLeft.setValue(result);
        stack.push(result);

        return false;
    }
}
