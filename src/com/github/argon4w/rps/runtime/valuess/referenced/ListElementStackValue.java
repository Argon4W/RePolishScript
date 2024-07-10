package com.github.argon4w.rps.runtime.valuess.referenced;

import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;

public record ListElementStackValue(IListStackValue list, int index, IStackValue value) implements IReferencedStackValue {
    public void setValue(IStackValue stackValue) {
        list.set(index, stackValue);
    }
}
