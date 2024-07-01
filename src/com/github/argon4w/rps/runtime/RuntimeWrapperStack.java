package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.RePolishRuntime;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.UndefinedStackValue;

import java.util.List;
import java.util.Map;

public class RuntimeWrapperStack extends RuntimeStack {
    public RuntimeWrapperStack(List<IInstruction> instructions, RuntimeStack parentStack, RuntimeBuiltinFunctions runtimeBuiltinFunctions, RePolishRuntime runtime) {
        super(instructions, parentStack, runtimeBuiltinFunctions, runtime);
    }

    @Override
    public RuntimeStack copyStack() {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public Map<String, IStackValue> initVariableStorage() {
        return parentStack.variableStorage;
    }

    @Override
    public IStackValue getVariableFromParent(String key) {
        return parentStack.parentStack == null ? new UndefinedStackValue() : parentStack.parentStack.getVariableInternal(key);
    }
}
