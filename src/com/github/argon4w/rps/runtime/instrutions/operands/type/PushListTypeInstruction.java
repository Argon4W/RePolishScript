package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.FunctionTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.IntegerTypeStackValue;

public class PushIntegerTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    ITypeStackValue getTypeStackValue() {
        return new IntegerTypeStackValue();
    }
}
