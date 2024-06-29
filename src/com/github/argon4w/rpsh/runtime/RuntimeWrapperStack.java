package com.github.argon4w.rpsh.runtime;

import com.github.argon4w.rpsh.RePolishRuntime;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IEndStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.ReturnStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

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
