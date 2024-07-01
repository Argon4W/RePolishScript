package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public record BooleanStackValue(boolean value) implements IAddableStackValue, IEquatableStackValue, IPrimitiveStackValue, IBitOperandStackValue {
    @Override
    public IStackValue add(IStackValue right) {
        if (!(right instanceof IStringStackValue stringValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new SingleQuotedStringStackValue(value + stringValue.value());
    }

    @Override
    public IStackValue bitAnd(IStackValue right) {
        if (!(right instanceof BooleanStackValue booleanValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new BooleanStackValue(value & booleanValue.value());
    }

    @Override
    public IStackValue bitOr(IStackValue right) {
        if (!(right instanceof BooleanStackValue booleanValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new BooleanStackValue(value | booleanValue.value());
    }

    @Override
    public IStackValue bitNot() {
        throw new IllegalStateException("Illegal left components");
    }

    @Override
    public IStackValue bitXOR(IStackValue right) {
        if (!(right instanceof BooleanStackValue booleanValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new BooleanStackValue(value ^ booleanValue.value());
    }

    @Override
    public IStackValue bitLeftShift(IStackValue right) {
        throw new IllegalStateException("Illegal left components");
    }

    @Override
    public IStackValue bitRightShift(IStackValue right) {
        throw new IllegalStateException("Illegal left components");
    }

    @Override
    public IStackValue bitUnsignedRightShift(IStackValue right) {
        throw new IllegalStateException("Illegal left components");
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
