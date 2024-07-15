package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public record ByteStackValue(byte value) implements INumericStackValue, IBitOperandStackValue {
    @Override
    public long getLongValue() {
        return (long) value;
    }

    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(value + stringStackValue.value());
        }

        if (right instanceof WideCharacterStackValue characterValue) {
            return new SingleQuotedStringStackValue(getStringValue(), characterValue.codePoint());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() + integerValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() + byteValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(getLongValue() + floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }


    @Override
    public IStackValue subtract(IStackValue right) {
        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() - integerValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() - byteValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(getLongValue() - floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue multiply(IStackValue right) {
        if (right instanceof ListStackValue listRight) {
            return listRight.multiply(value);
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() * integerValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() * byteValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(getLongValue() * floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue divide(IStackValue right) {
        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() / integerValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() / byteValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(getLongValue() / floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue mod(IStackValue right) {
        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() % integerValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() % byteValue.value());
        }

        if (right instanceof FloatingPointNumberStackValue floatingPointNumberStackValue) {
            return new FloatingPointNumberStackValue(getLongValue() % floatingPointNumberStackValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue invert() {
        return new IntegerStackValue(-getLongValue());
    }

    @Override
    public IStackValue bitAnd(IStackValue right) {
        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() & byteValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() & integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue bitOr(IStackValue right) {
        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() | byteValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() | integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue bitXOR(IStackValue right) {
        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() ^ byteValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() ^ integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue bitNot() {
        return new IntegerStackValue(~getLongValue());
    }

    @Override
    public IStackValue bitLeftShift(IStackValue right) {
        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() << byteValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() << integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue bitRightShift(IStackValue right) {
        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() >> byteValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() >> integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public IStackValue bitUnsignedRightShift(IStackValue right) {
        if (right instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(getLongValue() >>> byteValue.value());
        }

        if (right instanceof IntegerStackValue integerValue) {
            return new IntegerStackValue(getLongValue() >>> integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public int compare(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return Double.compare(getLongValue(), floatValue.value());
        }

        if (right instanceof ByteStackValue byteValue) {
            return Byte.compare(value, byteValue.value);
        }

        if (right instanceof IntegerStackValue integerValue) {
            return Long.compare(getLongValue(), integerValue.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof FloatingPointNumberStackValue floatValue) {
            return value == floatValue.value();
        }

        if (right instanceof ByteStackValue integerValue) {
            return value == integerValue.value;
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
