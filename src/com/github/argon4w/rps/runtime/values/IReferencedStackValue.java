package com.github.argon4w.rps.runtime.values;

public interface IReferencedStackValue extends IStackValue {
    IStackValue value();
    void setValue(IStackValue value);
}
