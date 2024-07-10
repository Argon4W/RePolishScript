package com.github.argon4w.rps.runtime.valuess.referenced;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

public interface IReferencedStackValue extends IStackValue {
    IStackValue value();
    void setValue(IStackValue value);
}
