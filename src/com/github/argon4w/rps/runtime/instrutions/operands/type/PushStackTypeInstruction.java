package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.RangeTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.StringTypeStackValue;

public class PushStringTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    ITypeStackValue getTypeStackValue() {
        return new StringTypeStackValue();
    }
}
