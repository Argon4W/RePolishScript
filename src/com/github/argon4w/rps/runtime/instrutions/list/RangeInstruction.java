package com.github.argon4w.rps.runtime.instrutions.list;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ByteStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.SimpleRangeStackValue;

public class RangeInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (right instanceof IntegerStackValue integerRight) {
            if (left instanceof IntegerStackValue integerLeft) {
                stack.push(new SimpleRangeStackValue(integerLeft.value(), integerRight.value()));
                return false;
            }

            if (left instanceof ByteStackValue byteLeft) {
                stack.push(new SimpleRangeStackValue(byteLeft.value(), integerRight.value()));
                return false;
            }

            throw new IllegalStateException("Illegal left components");
        }

        if (right instanceof ByteStackValue byteRight) {
            if (left instanceof IntegerStackValue integerLeft) {
                stack.push(new SimpleRangeStackValue(integerLeft.value(), byteRight.value()));
                return false;
            }

            if (left instanceof ByteStackValue byteLeft) {
                stack.push(new SimpleRangeStackValue(byteLeft.value(), byteLeft.value()));
                return false;
            }

            throw new IllegalStateException("Illegal left components");
        }

        throw new IllegalStateException("Illegal right components");
    }
}
