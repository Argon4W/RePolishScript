package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.RePolishRuntime;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.IEndStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ReturnStackValue;

import java.util.List;

public class RuntimeRootStack extends RuntimeStack {
    public RuntimeRootStack(List<IInstruction> instructions, RuntimeBuiltinFunctions runtimeBuiltinFunctions, RePolishRuntime runtime) {
        super(instructions, runtimeBuiltinFunctions, runtime);
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
