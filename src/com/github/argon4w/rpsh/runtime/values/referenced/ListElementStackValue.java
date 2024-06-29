package com.github.argon4w.rpsh.runtime.values.referenced;

import com.github.argon4w.rpsh.runtime.values.IListStackValue;
import com.github.argon4w.rpsh.runtime.values.IReferencedStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

public record ListElementStackValue(IListStackValue list, int index, IStackValue value) implements IReferencedStackValue {
    public void setValue(IStackValue stackValue) {
        list.set(index, stackValue);
    }
}
