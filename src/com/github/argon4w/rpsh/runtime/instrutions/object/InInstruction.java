package com.github.argon4w.rpsh.runtime.instrutions.object;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IListStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;
import com.github.argon4w.rpsh.runtime.values.loop.LoopListStackValue;
import com.github.argon4w.rpsh.runtime.values.loop.LoopRangeStackValue;
import com.github.argon4w.rpsh.runtime.values.loop.LoopStackStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.RangeStackValue;

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

            if (right instanceof RangeStackValue rangeRight) {
                stack.push(new LoopRangeStackValue(nameLeft, rangeRight));
                return false;
            }

            if (right instanceof RuntimeStack stackRight) {
                stack.push(new LoopStackStackValue(nameLeft, stackRight));
            }

            throw new IllegalStateException("Illegal right components");
        }

        if (right instanceof IListStackValue listRight) {
            if (left instanceof IntegerStackValue integerLeft) {
                stack.push(listRight.getSingle((int) integerLeft.value()));
                return false;
            }

            if (left instanceof RangeStackValue rangeLeft) {
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
