package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.BooleanTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.ByteTypeStackValue;

public class PushByteTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new ByteTypeStackValue();
    }
}
