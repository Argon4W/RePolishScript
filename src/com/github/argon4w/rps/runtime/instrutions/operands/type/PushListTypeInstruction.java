package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.IntegerTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.ListTypeStackValue;

public class PushListTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new ListTypeStackValue();
    }
}
