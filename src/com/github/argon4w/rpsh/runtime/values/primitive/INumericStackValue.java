package com.github.argon4w.rpsh.runtime.values;

public interface INumericStackValue extends IAddableStackValue, IEquatableStackValue, IComparableStackValue, IPrimitiveStackValue {
    IStackValue subtract(IStackValue right);
    IStackValue multiply(IStackValue right);
    IStackValue divide(IStackValue right);
    IStackValue mod(IStackValue right);
}
