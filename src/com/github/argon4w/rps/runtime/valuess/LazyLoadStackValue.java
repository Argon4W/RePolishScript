package com.github.argon4w.rps.runtime.valuess;

import com.github.argon4w.rps.runtime.RuntimeWrapperStack;

public record LazyLoadStackValue(RuntimeWrapperStack stack) implements IStackValue {
    public IStackValue loadValue() {
        stack.clear();
        stack.invoke();
        return stack.popResult();
    }
}
