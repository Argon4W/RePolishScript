package com.github.argon4w.rpsh.runtime.instrutions.bit;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IBitOperandStackValue;

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
