package com.github.argon4w.rpsh.runtime;

import com.github.argon4w.rpsh.RePolishRuntime;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.EmptyStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParameterStackValue;

import java.util.List;

public class RuntimeArrayStack extends RuntimeExpressionStack {
    public RuntimeArrayStack(List<IInstruction> instructions, RuntimeStack parentStack, RuntimeBuiltinFunctions runtimeBuiltinFunctions, RePolishRuntime runtime) {
        super(instructions, parentStack, runtimeBuiltinFunctions, runtime);
    }

    @Override
    public IStackValue getParalleled(ParalleledStackValue paralleledValue) {
        return new ListStackValue(paralleledValue.values);
    }

    @Override
    public IStackValue getResult(IStackValue value) {
        return value instanceof EmptyStackValue ? new ListStackValue() : new ListStackValue(List.of(value));
    }
}
