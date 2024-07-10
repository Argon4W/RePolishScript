package com.github.argon4w.rps.runtime.valuess.referenced;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.IStackValue;

public record VariableStackValue(RuntimeStack stack, String key, IStackValue value) implements IReferencedStackValue {
    public void setValue(IStackValue stackValue) {
        stack.setVariable(key, stackValue);
    }
}
