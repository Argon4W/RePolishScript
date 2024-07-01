package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.RePolishRuntime;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.EmptyStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rps.runtime.values.paralleled.ParalleledStackValue;

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
