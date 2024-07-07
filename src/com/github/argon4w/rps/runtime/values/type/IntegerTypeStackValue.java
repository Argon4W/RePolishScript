package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.*;

public class IntegerTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof IStringStackValue stringValue && stringValue.size() == 1) {
            return new IntegerStackValue(stringValue.codePoints().getValue(0));
        }

        if (value instanceof WideCharacterStackValue characterValue) {
            return new IntegerStackValue(characterValue.codePoint());
        }

        if (value instanceof ByteStackValue byteValue) {
            return new IntegerStackValue(byteValue.value());
        }

        if (value instanceof FloatingPointNumberStackValue floatValue) {
            return new IntegerStackValue((long) floatValue.value());
        }

        if (value instanceof IntegerStackValue) {
            return value;
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof IntegerStackValue;
    }
}
