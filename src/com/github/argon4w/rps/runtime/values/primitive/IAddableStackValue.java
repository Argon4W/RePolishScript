package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public interface IAddableStackValue extends IStackValue {
    IStackValue add(IStackValue right);
}
