package com.github.argon4w.rps.runtime.instrutions.bit;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IBitOperandStackValue;

public class BitRightShiftInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof IBitOperandStackValue bitOperandLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(bitOperandLeft.bitRightShift(right));
        return false;
    }
}
