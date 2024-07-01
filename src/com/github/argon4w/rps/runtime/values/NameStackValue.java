package com.github.argon4w.rps.runtime.values;

import com.github.argon4w.rps.runtime.RuntimeStack;

public record NameStackValue(String key, RuntimeStack stack) implements IStackValue {
    public void setValue(IStackValue stackValue) {
        stack.setVariable(key, stackValue);
    }

    public IStackValue getValue() {
        return stack.getVariable(key);
    }
}
