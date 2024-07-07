package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.ByteStackValue;
import com.github.argon4w.rps.runtime.values.primitive.FloatingPointNumberStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.values.primitive.WideCharacterStackValue;

public class WideCharacterTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof IntegerStackValue integerValue) {
            return new WideCharacterStackValue((int) integerValue.value());
        }

        if (value instanceof ByteStackValue byteValue) {
            return new WideCharacterStackValue(byteValue.value());
        }

        if (value instanceof FloatingPointNumberStackValue floatValue) {
            return new WideCharacterStackValue((int) floatValue.value());
        }

        if (value instanceof WideCharacterStackValue) {
            return value;
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof WideCharacterStackValue;
    }
}
