package com.github.argon4w.rps.runtime.values.referenced;

import com.github.argon4w.rps.runtime.values.IListStackValue;
import com.github.argon4w.rps.runtime.values.IReferencedStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;

public record ListElementStackValue(IListStackValue list, int index, IStackValue value) implements IReferencedStackValue {
    public void setValue(IStackValue stackValue) {
        list.set(index, stackValue);
    }
}
