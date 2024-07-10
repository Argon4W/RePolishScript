package com.github.argon4w.rps.runtime.valuess;

public interface ITypeStackValue extends IStackValue {
    IStackValue convert(IStackValue value);
    boolean is(IStackValue value);
}
