package com.github.argon4w.rpsh.runtime.values;

public interface IEquatableStackValue extends IStackValue {
    boolean equals(IStackValue right);
}
