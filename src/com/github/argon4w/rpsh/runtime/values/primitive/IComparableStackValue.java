package com.github.argon4w.rpsh.runtime.values;

public interface IComparableStackValue extends IStackValue {
    int compare(IStackValue right);
}
