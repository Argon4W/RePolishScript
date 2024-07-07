package com.github.argon4w.rps.runtime.instrutions.operands.type;

import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.type.StringTypeStackValue;
import com.github.argon4w.rps.runtime.values.type.WideCharacterTypeStackValue;

public class PushWideCharacterTypeInstruction extends AbstractPushTypeInstruction {
    @Override
    public ITypeStackValue getTypeStackValue() {
        return new WideCharacterTypeStackValue();
    }
}
