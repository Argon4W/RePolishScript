package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.FloatingPointNumberTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.FunctionTypeStackValue;

public class PushFunctionTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new FunctionTypeStackValue();
    }
}
