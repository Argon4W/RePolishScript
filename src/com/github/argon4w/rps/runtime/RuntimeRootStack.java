package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IEndStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ReturnStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.UndefinedStackValue;

import java.util.List;

public class RuntimeRootStack extends RuntimeStack {
    public RuntimeRootStack(IInstruction[] instructions, RuntimeCalls runtimeCalls, RePolishRuntime runtime) {
        super(instructions, runtimeCalls, runtime);
    }

    @Override
    public IStackValue getVariableFromParent(String key) {
        return new UndefinedStackValue();
    }

    @Override
    public RuntimeStack copyStack() {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public boolean shouldTerminate(IInstruction instruction, boolean result) {
        return result && instruction instanceof IEndStackValue;
    }

    @Override
    public synchronized IStackValue pop() {
        IStackValue result = super.pop();
        return result instanceof ReturnStackValue returnValue ? returnValue.value() : result;
    }
}
