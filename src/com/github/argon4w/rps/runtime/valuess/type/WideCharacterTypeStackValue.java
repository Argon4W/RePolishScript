package com.github.argon4w.rps.runtime.valuess.type;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ByteStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.FloatingPointNumberStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.WideCharacterStackValue;

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
