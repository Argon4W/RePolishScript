package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;

import java.util.LinkedHashMap;

public class RuntimeWrapperStack extends RuntimeStack {
    public RuntimeWrapperStack(IInstruction[] instructions, RuntimeCalls runtimeCalls, RePolishRuntime runtime) {
        super(instructions, runtimeCalls, runtime);
    }

    @Override
    public RuntimeStack copyStack() {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public LinkedHashMap<String, IStackValue> initVariableStorage() {
        return parentStack.variableStorage;
    }

    @Override
    public IStackValue getVariableFromParent(String key) {
        return parentStack.getVariableFromParent(key);
    }
}
