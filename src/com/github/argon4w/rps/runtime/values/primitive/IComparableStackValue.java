package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public interface IComparableStackValue extends IStackValue {
    int compare(IStackValue right);
}
