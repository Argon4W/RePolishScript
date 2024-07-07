package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.BooleanTypeStackValue;

public class PushBooleanTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    ITypeStackValue getTypeStackValue() {
        return new BooleanTypeStackValue();
    }
}
