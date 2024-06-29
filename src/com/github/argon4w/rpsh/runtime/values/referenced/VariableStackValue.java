package com.github.argon4w.rpsh.runtime.values.referenced;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.values.IReferencedStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

public record VariableStackValue(RuntimeStack stack, String key, IStackValue value) implements IReferencedStackValue {
    public void setValue(IStackValue stackValue) {
        stack.setVariable(key, stackValue);
    }
}
