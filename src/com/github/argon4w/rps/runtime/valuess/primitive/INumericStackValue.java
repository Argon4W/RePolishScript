package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface INumericStackValue extends IAddableStackValue, IMultiplierStackValue, IEquatableStackValue, IComparableStackValue, IPrimitiveStackValue {
    IStackValue subtract(IStackValue right);
    IStackValue divide(IStackValue right);
    IStackValue mod(IStackValue right);
}
