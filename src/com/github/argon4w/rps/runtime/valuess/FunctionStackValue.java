package com.github.argon4w.rps.runtime.valuess;

import com.github.argon4w.rps.runtime.RuntimeStack;

import java.util.ArrayList;
import java.util.List;

public class FunctionStackValue implements IStackValue {
    public final RuntimeStack stack;
    public final List<NameStackValue> parameters;
    public final boolean vaParameter;

    public FunctionStackValue(RuntimeStack stack) {
        this.stack = stack;
        this.parameters = List.of();
        this.vaParameter = false;
    }

    public FunctionStackValue(RuntimeStack stack, IStackValue leftValue) {
        List<IStackValue> leftValues = leftValue instanceof ParameterStackValue parameterValue ? parameterValue.values : List.of(leftValue);
        List<NameStackValue> parameters = new ArrayList<>();
        boolean vaParameter = false;

        for (IStackValue stackValue : leftValues) {
            if (stackValue instanceof VaParameterStackValue) {
                vaParameter = true;
                continue;
            }

            if (vaParameter) {
                throw new IllegalStateException("Illegal parameter definition after variable parameters");
            }

            if (!(stackValue instanceof NameStackValue nameValue)) {
                throw new IllegalStateException("Illegal parameter definition");
            }

            if (parameters.contains(nameValue)) {
                throw new IllegalStateException("Illegal duplicated parameter definition");
            }

            parameters.add(nameValue);
        }

        this.stack = stack;
        this.parameters = parameters;
        this.vaParameter = vaParameter;
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

        if (vaParameter ? values.size() < parameters.size() : values.size() != parameters.size()) {
            throw new IllegalStateException("Mismatch parameters");
        }

        for (int i = 0; i < parameters.size(); i ++) {
            copiedStack.setVariable(parameters.get(i).key(), values.get(i));
        }

        if (vaParameter) {
            copiedStack.setVariable("parameters", new ParameterStackValue(values.subList(parameters.size(), values.size())));
        }

        copiedStack.invoke();
        return copiedStack.popReturnedResult();
    }
}
