package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public class UndefinedStackValue implements IStackValue, IEquatableStackValue, IPrimitiveStackValue, IAddableStackValue {
    @Override
    public boolean equals(IStackValue right) {
        return right instanceof UndefinedStackValue;
    }

    @Override
    public IStackValue add(IStackValue right) {
        if (!(right instanceof IStringStackValue stringValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        return new SingleQuotedStringStackValue("null", stringValue.codePoints());
    }

    @Override
    public String getStringValue() {
        return "null";
    }
}
