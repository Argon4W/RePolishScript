package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public record IntegerStackValue(long value) implements INumericStackValue, IBitOperandStackValue {
    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(value + stringStackValue.value());
        }

        if (right instanceof IntegerStackValue integerStackValue) {
            return new IntegerStackValue(value + integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(value + floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }


    @Override
    public IStackValue subtract(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new IntegerStackValue(value - integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(value - floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue multiply(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new IntegerStackValue(value * integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(value * floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue divide(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new IntegerStackValue(value / integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(value / floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue mod(IStackValue right) {
        if (right instanceof IntegerStackValue integerStackValue) {
            return new IntegerStackValue(value % integerStackValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(value % floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue bitAnd(IStackValue right) {
        if (!(right instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new IntegerStackValue(value & integerValue.value());
    }

    @Override
    public IStackValue bitOr(IStackValue right) {
        if (!(right instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new IntegerStackValue(value | integerValue.value());
    }

    @Override
    public IStackValue bitXOR(IStackValue right) {
        if (!(right instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new IntegerStackValue(value ^ integerValue.value());
    }

    @Override
    public IStackValue bitNot() {
        return new IntegerStackValue(~value);
    }

    @Override
    public IStackValue bitLeftShift(IStackValue right) {
        if (!(right instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new IntegerStackValue(value << integerValue.value());
    }

    @Override
    public IStackValue bitRightShift(IStackValue right) {
        if (!(right instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new IntegerStackValue(value >> integerValue.value());
    }

    @Override
    public IStackValue bitUnsignedRightShift(IStackValue right) {
        if (!(right instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new IntegerStackValue(value >>> integerValue.value());
    }

    @Override
    public int compare(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return Double.compare(value, floatValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return Long.compare(value, integerValue.value);
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return value == floatValue.value();
        }

        if (right instanceof IntegerStackValue integerValue) {
            return value == integerValue.value;
        }

        return false;
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }
}
