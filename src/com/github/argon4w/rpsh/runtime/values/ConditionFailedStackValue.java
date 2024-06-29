package com.github.argon4w.rpsh.runtime.values;

import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

public class ConditionFailedStackValue implements IStackValue, IEquatableStackValue {
    @Override
    public boolean equals(IStackValue right) {
        return right instanceof UndefinedStackValue;
    }
}
