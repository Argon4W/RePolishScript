package com.github.argon4w.rpsh.runtime.values.primitive;

import com.github.argon4w.rpsh.runtime.values.*;

public record BooleanStackValue(boolean value) implements IAddableStackValue, IEquatableStackValue, IPrimitiveStackValue {
    @Override
    public IStackValue add(IStackValue right) {
        if (!(right instanceof IStringStackValue stringValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new SingleQuotedStringStackValue(value + stringValue.value());
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof BooleanStackValue booleanValue) {
            return value == booleanValue.value;
        }

        if (right instanceof UndefinedStackValue) {
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }
}
