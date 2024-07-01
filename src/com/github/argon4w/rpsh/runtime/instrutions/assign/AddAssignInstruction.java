package com.github.argon4w.rpsh.runtime.instrutions.assign;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IReferencedStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;

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
