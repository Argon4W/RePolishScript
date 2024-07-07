package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;

public class BooleanTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof BooleanTypeStackValue;
    }
}
