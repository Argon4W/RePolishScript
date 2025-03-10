package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;
import com.github.argon4w.rps.runtime.valuess.type.ByteTypeStackValue;

public class PushByteTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new ByteTypeStackValue();
    }
}
