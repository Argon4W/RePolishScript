package com.github.argon4w.rpsh.runtime.values.primitive;

import com.github.argon4w.rpsh.runtime.values.*;

public record WideCharacterStackValue(int codePoint) implements IAddableStackValue, IEquatableStackValue, IPrimitiveStackValue {
    @Override
    public String getStringValue() {
        return new String(Character.toChars(codePoint));
    }

    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof WideCharacterStackValue charValue) {
            return new SingleQuotedStringStackValue(codePoint, charValue.codePoint);
        }

        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(codePoint, stringStackValue.codePoints());
        }

        if (right instanceof IPrimitiveStackValue primitiveRight) {
            return new SingleQuotedStringStackValue(codePoint, primitiveRight.getStringValue());
        }

        throw new IllegalStateException("Illegal right components: " + right.getClass().getSimpleName());
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof WideCharacterStackValue charValue) {
            return codePoint == charValue.codePoint;
        }

        if (right instanceof IStringStackValue stringValue) {
            return new IntArraySlice(codePoint).equals(stringValue.codePoints());
        }

        if (right instanceof UndefinedStackValue) {
            return false;
        }

        throw new IllegalStateException("Illegal right components");
    }
}
