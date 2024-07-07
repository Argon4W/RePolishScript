package com.github.argon4w.rps.runtime.values;

public interface ITypeStackValue extends IStackValue {
    IStackValue convert(IStackValue value);
    boolean is(IStackValue value);
}
