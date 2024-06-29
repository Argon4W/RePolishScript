package com.github.argon4w.rpsh.runtime.values.primitive;

import com.github.argon4w.rpsh.runtime.values.INumericStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;

public record FloatingPointNumberStackValue(double value) implements INumericStackValue {
    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(value + stringStackValue.value());
        }

        if (right instanceof IntegerStackValue integerStackValue) {
            return new FloatingPointNumberStackValue(value + integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return new FloatingPointNumberStackValue(value + floatValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue subtract(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new FloatingPointNumberStackValue(value - integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return new FloatingPointNumberStackValue(value - floatValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue multiply(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new FloatingPointNumberStackValue(value * integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return new FloatingPointNumberStackValue(value * floatValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue divide(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new FloatingPointNumberStackValue(value / integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return new FloatingPointNumberStackValue(value / floatValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public int compare(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return Double.compare(value, floatValue.value);
        }

        if (right instanceof IntegerStackValue integerValue) {
            return Double.compare(value, integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return value == floatValue.value;
        }

        if (right instanceof IntegerStackValue integerValue) {
            return value == integerValue.value();
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
