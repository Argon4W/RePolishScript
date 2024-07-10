package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public record FloatingPointNumberStackValue(double value) implements INumericStackValue {
    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(value + stringStackValue.value());
        }

        if (right instanceof WideCharacterStackValue characterValue) {
            return new SingleQuotedStringStackValue(getStringValue(), characterValue.codePoint());
        }

        if (right instanceof IntegerStackValue integerStackValue) {
            return new FloatingPointNumberStackValue(value + integerStackValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new FloatingPointNumberStackValue(value + byteValue.getLongValue());
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

        if (right instanceof ByteStackValue byteValue) {
            return new FloatingPointNumberStackValue(value - byteValue.getLongValue());
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

        if (right instanceof ByteStackValue byteValue) {
            return new FloatingPointNumberStackValue(value * byteValue.getLongValue());
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

        if (right instanceof ByteStackValue byteValue) {
            return new FloatingPointNumberStackValue(value / byteValue.getLongValue());
        }

        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return new FloatingPointNumberStackValue(value / floatValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue mod(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new FloatingPointNumberStackValue(value % integerStackValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new FloatingPointNumberStackValue(value % byteValue.getLongValue());
        }

        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return new FloatingPointNumberStackValue(value % floatValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public int compare(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return Double.compare(value, floatValue.value);
        }

        if (right instanceof ByteStackValue byteValue) {
            return Double.compare(value, byteValue.getLongValue());
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

        if (right instanceof ByteStackValue byteValue) {
            return value == byteValue.value();
        }

        if (right instanceof IntegerStackValue integerValue) {
            return value == integerValue.value();
        }

        return false;
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }
}
