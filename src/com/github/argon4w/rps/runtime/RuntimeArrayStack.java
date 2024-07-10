package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.EmptyStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ListStackValue;

import java.util.List;

public class RuntimeArrayStack extends RuntimeExpressionStack {
    public RuntimeArrayStack(IInstruction[] instructions, RuntimeCalls runtimeCalls, RePolishRuntime runtime) {
        super(instructions, runtimeCalls, runtime);
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
