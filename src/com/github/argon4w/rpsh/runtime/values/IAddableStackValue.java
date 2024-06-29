package com.github.argon4w.rpsh.runtime.values;

public interface IAddableStackValue extends IStackValue {
    IStackValue add(IStackValue right);
}
