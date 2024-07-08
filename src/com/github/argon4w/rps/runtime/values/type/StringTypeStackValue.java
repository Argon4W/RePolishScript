package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.*;

public class StringTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof IStringStackValue) {
            return value;
        }

        if (value instanceof IPrimitiveStackValue primitiveValue) {
            return new SingleQuotedStringStackValue(primitiveValue.getStringValue());
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof IStringStackValue;
    }
}
