package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.ByteTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.FloatingPointNumberTypeStackValue;

public class PushFloatingPointNumberTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new FloatingPointNumberTypeStackValue();
    }
}
