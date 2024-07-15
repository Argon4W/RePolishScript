package com.github.argon4w.rps.runtime.instrutions.assign;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.UndefinedStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.IReferencedStackValue;

public class ShortCircuitFallbackAssignInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReserved();
        IStackValue left = stack.popReserved();

        if (!(right instanceof RuntimeWrapperStack stackRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        if (!(left instanceof IReferencedStackValue referenceLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (referenceLeft.value() instanceof UndefinedStackValue) {
            stackRight.clear();
            stackRight.invoke();

            IStackValue result = stackRight.popResult();
            referenceLeft.setValue(result);
            stack.push(result);

            return false;
        }

        stack.push(left);
        return false;
    }
}
