package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface IAddableStackValue extends IStackValue {
    IStackValue add(IStackValue right);
}
