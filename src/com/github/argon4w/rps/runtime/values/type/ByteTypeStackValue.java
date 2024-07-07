package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.*;

public class ByteTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof IStringStackValue stringValue && stringValue.size() == 1) {
            return new ByteStackValue((byte) stringValue.codePoints().getValue(0));
        }

        if (value instanceof WideCharacterStackValue characterValue) {
            return new ByteStackValue((byte) characterValue.codePoint());
        }

        if (value instanceof IntegerStackValue integerValue) {
            return new ByteStackValue((byte) integerValue.value());
        }

        if (value instanceof FloatingPointNumberStackValue floatValue) {
            return new ByteStackValue((byte) floatValue.value());
        }

        if (value instanceof ByteStackValue) {
            return value;
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof ByteStackValue;
    }
}
