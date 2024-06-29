package com.github.argon4w.rpsh.runtime.values;

public interface IReferencedStackValue extends IStackValue {
    IStackValue value();
    void setValue(IStackValue value);
}
