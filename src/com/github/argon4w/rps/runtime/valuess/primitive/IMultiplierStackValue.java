package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface IMultiplierStackValue extends IStackValue {
    IStackValue multiply(IStackValue right);
}
