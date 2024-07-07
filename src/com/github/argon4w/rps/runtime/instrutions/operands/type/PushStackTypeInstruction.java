package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.StackTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.StringTypeStackValue;

public class PushStackTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new StackTypeStackValue();
    }
}
