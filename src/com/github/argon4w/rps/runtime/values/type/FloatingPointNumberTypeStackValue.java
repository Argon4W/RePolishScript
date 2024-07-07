package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.*;

public class FloatingPointNumberTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof IStringStackValue stringValue && stringValue.size() == 1) {
            return new FloatingPointNumberStackValue(stringValue.codePoints().getValue(0));
        }

        if (value instanceof WideCharacterStackValue characterValue) {
            return new FloatingPointNumberStackValue(characterValue.codePoint());
        }

        if (value instanceof ByteStackValue byteValue) {
            return new FloatingPointNumberStackValue(byteValue.value());
        }

        if (value instanceof IntegerStackValue integerValue) {
            return new FloatingPointNumberStackValue(integerValue.value());
        }

        if (value instanceof FloatingPointNumberStackValue) {
            return value;
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof FloatingPointNumberStackValue;
    }
}
