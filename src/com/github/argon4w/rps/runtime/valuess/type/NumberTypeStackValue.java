package com.github.argon4w.rps.runtime.valuess.type;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

public class NumberTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof INumericStackValue) {
            return value;
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof INumericStackValue;
    }
}