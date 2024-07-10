package com.github.argon4w.rps.runtime.valuess.type;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IPrimitiveStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IStringStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.SingleQuotedStringStackValue;

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
