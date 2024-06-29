package com.github.argon4w.rpsh.runtime;

import com.github.argon4w.rpsh.RePolishRuntime;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IEndStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.ReturnStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParameterStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

import java.util.List;
import java.util.Map;

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
