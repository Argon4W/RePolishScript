package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.ParameterStackValue;

import java.util.LinkedHashMap;

public class RuntimeExpressionStack extends RuntimeStack {
    public RuntimeExpressionStack(IInstruction[] instructions, RuntimeCalls runtimeCalls, RePolishRuntime runtime) {
        super(instructions, runtimeCalls, runtime);
    }

    @Override
    public LinkedHashMap<String, IStackValue> initVariableStorage() {
        return parentStack.variableStorage;
    }

    @Override
    public IStackValue getVariableFromParent(String key) {
        return parentStack.getVariableFromParent(key);
    }

    @Override
    public RuntimeStack copyStack() {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public IStackValue invoke() {
        super.invoke();
        IStackValue result = popResult();
        return result instanceof ParalleledStackValue paralleledValue ? getParalleled(paralleledValue) : getResult(result);
    }

    public IStackValue getResult(IStackValue value) {
        return value;
    }

    public IStackValue getParalleled(ParalleledStackValue paralleledValue) {
        return new ParameterStackValue(paralleledValue);
    }
}
