package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;

public abstract class AbstractPushTypeInstruction implements IInstruction {
    public abstract ITypeStackValue getTypeStackValue();

    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(getTypeStackValue());
        return false;
    }
}
