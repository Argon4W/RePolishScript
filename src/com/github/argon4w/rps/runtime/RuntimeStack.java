package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.EmptyStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.LazyLoadStackValue;
import com.github.argon4w.rps.runtime.valuess.ReturnStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.BooleanStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.UndefinedStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.IReferencedStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.VariableStackValue;

import java.util.LinkedHashMap;
import java.util.Stack;

public class RuntimeStack extends Stack<IStackValue> implements IStackValue {
    public final RuntimeCalls runtimeCalls;
    public final IInstruction[] instructions;
    public final RePolishRuntime runtime;

    public RuntimeStack parentStack;
    public LinkedHashMap<String, IStackValue> variableStorage;

    public RuntimeStack(IInstruction[] instructions, RuntimeCalls runtimeCalls, RePolishRuntime runtime) {
        this.runtimeCalls = runtimeCalls;
        this.instructions = instructions;
        this.runtime = runtime;
    }

    public RuntimeStack initStack(RuntimeStack parentStack) {
        clear();
        this.parentStack = parentStack;
        this.variableStorage = initVariableStorage();
        return this;
    }

    public LinkedHashMap<String, IStackValue> initVariableStorage() {
        return new LinkedHashMap<>();
    }

    public boolean hasVariable(String key) {
        return variableStorage.containsKey(key);
    }

    public void setVariable(String key, IStackValue value) {
        variableStorage.put(key, value);
    }

    public IStackValue getVariable(String key) {
        IStackValue value = getVariableInternal(key);
        return value instanceof UndefinedStackValue ? new VariableStackValue(this, key, value) : value;
    }

    public IStackValue getVariableInternal(String key) {
        return variableStorage.containsKey(key) ? new VariableStackValue(this, key, getLoadedVariable(key)) : getVariableFromParent(key);
    }

    public IStackValue getLoadedVariable(String key) {
        return variableStorage.computeIfPresent(key, (s, value) -> value instanceof LazyLoadStackValue lazyValue ? lazyValue.loadValue() : value);
    }

    public IStackValue getVariableFromParent(String key) {
        return parentStack == null ? new UndefinedStackValue() : parentStack.getVariableInternal(key);
    }

    public IStackValue invoke() {
        for (int i = 0; i < instructions.length && !invokeInstruction(instructions[i]); i ++);
        return this;
    }

    public boolean invokeInstruction(IInstruction instruction) {
        return shouldTerminate(instruction, instruction.invoke(this));
    }

    public boolean shouldTerminate(IInstruction instruction, boolean result) {
        return result;
    }

    public synchronized IStackValue popReturnedResult() {
        IStackValue result = popResult();
        return result instanceof ReturnStackValue returnedValue ? returnedValue.value() : result;
    }

    public synchronized boolean popBooleanResult() {
        return popResult() instanceof BooleanStackValue booleanValue && booleanValue.value();
    }

    public synchronized IStackValue popResult() {
        return empty() ? new EmptyStackValue() : pop();
    }

    public synchronized IStackValue popReserved() {
        return super.pop();
    }

    public RuntimeStack copyStack() {
        return new RuntimeStack(instructions, runtimeCalls, runtime).initStack(parentStack);
    }

    @Override
    public synchronized IStackValue pop() {
        IStackValue value = super.pop();

        if (value instanceof IReferencedStackValue referencedValue) {
            return referencedValue.value();
        }

        if (value instanceof RuntimeStack stackValue) {
            return stackValue.invoke();
        }

        return value;
    }
}
