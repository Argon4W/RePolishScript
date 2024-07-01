package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public interface IEquatableStackValue extends IStackValue {
    boolean equals(IStackValue right);
}
