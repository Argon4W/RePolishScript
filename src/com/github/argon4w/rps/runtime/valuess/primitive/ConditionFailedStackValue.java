package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public class ConditionFailedStackValue implements IStackValue, IEquatableStackValue {
    @Override
    public boolean equals(IStackValue right) {
        return right instanceof UndefinedStackValue;
    }
}
