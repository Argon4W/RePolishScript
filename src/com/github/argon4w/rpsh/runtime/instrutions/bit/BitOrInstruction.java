package com.github.argon4w.rpsh.runtime.instrutions.logic;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.BooleanStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IBitOperandStackValue;

public class OrInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (left instanceof IBitOperandStackValue bitOperandLeft) {
            stack.push(bitOperandLeft.bitOr(right));
            return false;
        }

        if (!(left instanceof BooleanStackValue booleanLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (!(right instanceof BooleanStackValue booleanRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(new BooleanStackValue(booleanLeft.value() | booleanRight.value()));
        return false;
    }
}
