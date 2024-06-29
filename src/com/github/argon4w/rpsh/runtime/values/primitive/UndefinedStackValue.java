package com.github.argon4w.rpsh.runtime.values.primitive;

import com.github.argon4w.rpsh.runtime.values.IEquatableStackValue;
import com.github.argon4w.rpsh.runtime.values.IPrimitiveStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

public class UndefinedStackValue implements IStackValue, IEquatableStackValue, IPrimitiveStackValue {
    @Override
    public boolean equals(IStackValue right) {
        return right instanceof UndefinedStackValue;
    }

    @Override
    public String getStringValue() {
        return "null";
    }
}
