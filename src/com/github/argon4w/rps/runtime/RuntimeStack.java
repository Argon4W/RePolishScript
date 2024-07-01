package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.RePolishRuntime;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.EmptyStackValue;
import com.github.argon4w.rps.runtime.values.IReferencedStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ReturnStackValue;
import com.github.argon4w.rps.runtime.values.primitive.BooleanStackValue;
import com.github.argon4w.rps.runtime.values.primitive.UndefinedStackValue;
import com.github.argon4w.rps.runtime.values.referenced.VariableStackValue;

import java.util.*;

public class RuntimeStack extends Stack<IStackValue> implements IStackValue {
    public final RuntimeBuiltinFunctions runtimeBuiltinFunctions;
    public final RuntimeStack parentStack;
    public final List<IInstruction> instructions;
    public final List<IInstruction> stackInstructions;
    public final RePolishRuntime runtime;

    public Map<String, IStackValue> variableStorage;

    public RuntimeStack(List<IInstruction> instructions, RuntimeStack parentStack, RuntimeBuiltinFunctions runtimeBuiltinFunctions, RePolishRuntime runtime) {
        this.runtimeBuiltinFunctions = runtimeBuiltinFunctions;
        this.parentStack = parentStack;
        this.instructions = List.copyOf(instructions);
        this.stackInstructions = new ArrayList<>();
        this.runtime = runtime;

        this.variableStorage = initVariableStorage();
    }

    public RuntimeStack(List<IInstruction> instructions, RuntimeBuiltinFunctions runtimeBuiltinFunctions, RePolishRuntime runtime) {
        this(instructions, null, runtimeBuiltinFunctions, runtime);
    }

    public Map<String, IStackValue> initVariableStorage() {
        return new HashMap<>();
    }

    public void addStackInstructions(IInstruction instruction) {
        stackInstructions.add(instruction);
    }

    public void setVariable(String key, IStackValue value) {
        variableStorage.put(key, value);
    }

    public IStackValue getVariable(String key) {
        IStackValue value = getVariableInternal(key);
        return value instanceof UndefinedStackValue ? new VariableStackValue(this, key, value) : value;
    }

    public IStackValue getVariableInternal(String key) {
        return variableStorage.containsKey(key) ? new VariableStackValue(this, key, variableStorage.get(key)) : getVariableFromParent(key);
    }

    public IStackValue getVariableFromParent(String key) {
        return parentStack == null ? new UndefinedStackValue() : parentStack.getVariableInternal(key);
    }

    public void pushWrapperStack() {
        push(new RuntimeWrapperStack(stackInstructions, this, runtimeBuiltinFunctions, runtime));
        stackInstructions.clear();
    }

    public void pushArrayStack() {
        push(new RuntimeArrayStack(stackInstructions, this, runtimeBuiltinFunctions, runtime));
        stackInstructions.clear();
    }

    public void pushExpressionStack() {
        push(new RuntimeExpressionStack(stackInstructions, this, runtimeBuiltinFunctions, runtime));
        stackInstructions.clear();
    }

    public void pushStack() {
        push(new RuntimeStack(stackInstructions, this, runtimeBuiltinFunctions, runtime));
        stackInstructions.clear();
    }

    public IStackValue invoke() {
        for (int i = 0; i < instructions.size() && !invokeInstruction(instructions.get(i)); i ++);
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

    public synchronized IStackValue popReversed() {
        return super.pop();
    }

    public RuntimeStack copyStack() {
        return new RuntimeStack(instructions, parentStack, runtimeBuiltinFunctions, runtime);
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
