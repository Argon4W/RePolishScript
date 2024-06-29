package com.github.argon4w.rpsh.runtime;

import com.github.argon4w.rpsh.RePolishRuntime;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParameterStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

import java.util.List;
import java.util.Map;

public class RuntimeExpressionStack extends RuntimeStack {
    public RuntimeExpressionStack(List<IInstruction> instructions, RuntimeStack parentStack, RuntimeBuiltinFunctions runtimeBuiltinFunctions, RePolishRuntime runtime) {
        super(instructions, parentStack, runtimeBuiltinFunctions, runtime);
    }

    @Override
    public Map<String, IStackValue> initVariableStorage() {
        return parentStack.variableStorage;
    }

    @Override
    public IStackValue getVariableFromParent(String key) {
        return parentStack.parentStack == null ? new UndefinedStackValue() : parentStack.parentStack.getVariableInternal(key);
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
