package com.github.argon4w.rpsh.runtime.values;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParameterStackValue;

import java.util.ArrayList;
import java.util.List;

public class FunctionStackValue implements IStackValue {
    public final RuntimeStack stack;
    public final List<NameStackValue> parameters;

    public FunctionStackValue(RuntimeStack stack) {
        this.stack = stack;
        this.parameters = List.of();
    }

    public FunctionStackValue(RuntimeStack stack, IStackValue value) {
        this.stack = stack;
        this.parameters = toNames(value instanceof ParameterStackValue parameterValue ? parameterValue.values : List.of(value));
    }

    public List<NameStackValue> toNames(List<IStackValue> values) {
        ArrayList<NameStackValue> names = new ArrayList<>();

        for (IStackValue value : values) {
            if (!(value instanceof NameStackValue nameValue)) {
                throw new IllegalStateException("Illegal parameter definition");
            }

            if (names.contains(nameValue)) {
                throw new IllegalStateException("Illegal duplicated parameter definition");
            }

            names.add(nameValue);
        }

        return names;
    }

    public IStackValue invoke(IStackValue value) {
        if (value instanceof EmptyStackValue) {
            return invoke(List.of());
        }

        if (!(value instanceof ParameterStackValue parameterValue)) {
            return invoke(List.of(value));
        }

        return invoke(parameterValue.values);
    }

    public IStackValue invoke(List<IStackValue> values) {
        RuntimeStack copiedStack = stack.copyStack();

        if (values.size() != parameters.size()) {
            throw new IllegalStateException("Mismatch parameters");
        }

        for (int i = 0; i < values.size(); i ++) {
            copiedStack.setVariable(parameters.get(i).key(), values.get(i));
        }

        copiedStack.invoke();
        return copiedStack.popReturnedResult();
    }
}
