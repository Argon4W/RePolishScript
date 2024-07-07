package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.ListTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.NumberTypeStackValue;

public class PushNumberTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    ITypeStackValue getTypeStackValue() {
        return new NumberTypeStackValue();
    }
}
