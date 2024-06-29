package com.github.argon4w.rpsh.runtime.instrutions;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;

import java.util.List;

public class ParalleledInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (left instanceof ListStackValue) {
            throw new IllegalStateException("Illegal paralleled components");
        }

        if (left instanceof ParalleledStackValue paralleledLeft) {
            stack.push(paralleledLeft.addRight(right));
            return false;
        }

        stack.push(new ParalleledStackValue(List.of(left)).addRight(right));
        return false;
    }
}
