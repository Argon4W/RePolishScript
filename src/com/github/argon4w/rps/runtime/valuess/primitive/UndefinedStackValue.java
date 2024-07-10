package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public class UndefinedStackValue implements IStackValue, IEquatableStackValue, IPrimitiveStackValue, IAddableStackValue {
    @Override
    public boolean equals(IStackValue right) {
        return right instanceof UndefinedStackValue;
    }

    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof IStringStackValue stringValue) {
            return new SingleQuotedStringStackValue("null", stringValue.codePoints());
        }

        if (right instanceof WideCharacterStackValue characterValue) {
            return new SingleQuotedStringStackValue("null", characterValue.codePoint());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public String getStringValue() {
        return "null";
    }
}
