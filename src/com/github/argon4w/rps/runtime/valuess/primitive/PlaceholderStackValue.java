package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public class PlaceholderStackValue implements INumericStackValue {
    @Override
    public IStackValue add(IStackValue right) {
        return right;
    }

    @Override
    public IStackValue subtract(IStackValue right) {
        if (!(right instanceof INumericStackValue numericValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return numericValue.invert();
    }

    @Override
    public IStackValue divide(IStackValue right) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public IStackValue mod(IStackValue right) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public IStackValue invert() {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public int compare(IStackValue right) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public boolean equals(IStackValue right) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public IStackValue multiply(IStackValue right) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public String getStringValue() {
        throw new IllegalStateException("Illegal operation");
    }
}
