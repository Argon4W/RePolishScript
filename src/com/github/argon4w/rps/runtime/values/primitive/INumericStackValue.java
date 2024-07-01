package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

public interface INumericStackValue extends IAddableStackValue, IEquatableStackValue, IComparableStackValue, IPrimitiveStackValue {
    IStackValue subtract(IStackValue right);
    IStackValue multiply(IStackValue right);
    IStackValue divide(IStackValue right);
    IStackValue mod(IStackValue right);
}
