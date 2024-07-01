package com.github.argon4w.rpsh.runtime.instrutions.assign;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IReferencedStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IBitOperandStackValue;

public class BitRightShiftAssignInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReversed();

        if (!(left instanceof IReferencedStackValue referenceLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        left = referenceLeft.value();

        if (!(left instanceof IBitOperandStackValue bitOperandLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        IStackValue result = bitOperandLeft.bitRightShift(right);
        referenceLeft.setValue(result);
        stack.push(result);

        return false;
    }
}
