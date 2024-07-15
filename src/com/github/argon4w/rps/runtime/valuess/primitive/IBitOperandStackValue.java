package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface IBitOperandStackValue extends IStackValue {
    IStackValue bitAnd(IStackValue right);
    IStackValue bitOr(IStackValue right);
    IStackValue bitNot();
    IStackValue bitXOR(IStackValue right);
    IStackValue bitLeftShift(IStackValue right);
    IStackValue bitRightShift(IStackValue right);
    IStackValue bitUnsignedRightShift(IStackValue right);
    long getLongValue();
}
