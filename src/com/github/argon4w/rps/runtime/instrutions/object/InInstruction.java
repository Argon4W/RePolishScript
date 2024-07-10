package com.github.argon4w.rps.runtime.instrutions.object;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;
import com.github.argon4w.rps.runtime.valuess.loop.LoopListStackValue;
import com.github.argon4w.rps.runtime.valuess.loop.LoopRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.loop.LoopStackStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.*;

public class InInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (left instanceof NameStackValue nameLeft) {
            if (right instanceof IListStackValue listRight) {
                stack.push(new LoopListStackValue(nameLeft, listRight));
                return false;
            }

            if (right instanceof IRangeStackValue rangeRight) {
                stack.push(new LoopRangeStackValue(nameLeft, rangeRight));
                return false;
            }

            if (right instanceof RuntimeStack stackRight) {
                stack.push(new LoopStackStackValue(nameLeft, stackRight));
            }

            throw new IllegalStateException("Illegal right components");
        }

        if (right instanceof IListStackValue listRight) {
            if (left instanceof ByteStackValue byteValue) {
                stack.push(listRight.getSingle(byteValue.value()));
                return false;
            }

            if (left instanceof IntegerStackValue integerLeft) {
                stack.push(listRight.getSingle((int) integerLeft.value()));
                return false;
            }

            if (left instanceof IRangeStackValue rangeLeft) {
                stack.push(listRight.getRange(rangeLeft));
                return false;
            }

            if (left instanceof ParalleledStackValue paralleled) {
                stack.push(listRight.getRange(paralleled));
                return false;
            }

            throw new IllegalStateException("Illegal left components");
        }

        if (left instanceof IStringStackValue stringLeft && right instanceof RuntimeStack stackRight) {
            stack.push(stackRight.getVariable(stringLeft.value()));
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }
}
