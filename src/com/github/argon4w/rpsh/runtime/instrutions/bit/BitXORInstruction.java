package com.github.argon4w.rpsh.runtime.instrutions.bit;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IBitOperandStackValue;

public class BitXORInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof IBitOperandStackValue bitOperandRight)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(bitOperandRight.bitNot());
        return false;
    }
}
