package com.github.argon4w.rps.runtime.instrutions.assign;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.IReferencedStackValue;

public class AssignInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReversed();

        if (left instanceof NameStackValue nameLeft) {
            nameLeft.setValue(right);
            stack.push(right);
            return false;
        }

        if (left instanceof IReferencedStackValue referenceLeft) {
            referenceLeft.setValue(right);
            stack.push(right);
            return false;
        }

        throw new IllegalStateException("Illegal left components");
    }
}
