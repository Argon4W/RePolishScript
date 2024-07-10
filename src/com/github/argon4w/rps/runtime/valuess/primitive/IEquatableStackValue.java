package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface IEquatableStackValue extends IStackValue {
    boolean equals(IStackValue right);
}
