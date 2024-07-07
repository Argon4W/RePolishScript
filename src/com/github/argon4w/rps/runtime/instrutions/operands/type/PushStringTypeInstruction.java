package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.NumberTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.RangeTypeStackValue;

public class PushRangeTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    ITypeStackValue getTypeStackValue() {
        return new RangeTypeStackValue();
    }
}
