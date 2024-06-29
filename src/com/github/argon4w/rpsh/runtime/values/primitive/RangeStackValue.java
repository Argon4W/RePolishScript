package com.github.argon4w.rpsh.runtime.values.primitive;

import com.github.argon4w.rpsh.runtime.values.IEquatableStackValue;
import com.github.argon4w.rpsh.runtime.values.IPrimitiveStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

public record RangeStackValue(long min, long max) implements IStackValue, IEquatableStackValue, IPrimitiveStackValue {
    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof RangeStackValue rangeValue) {
            return min == rangeValue.min && max == rangeValue.max;
        }

        if (right instanceof UndefinedStackValue) {
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public String getStringValue() {
        return min + ".." + max;
    }
}
