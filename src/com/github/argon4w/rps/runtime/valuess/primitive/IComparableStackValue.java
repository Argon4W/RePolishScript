package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface IComparableStackValue extends IStackValue {
    int compare(IStackValue right);
}
