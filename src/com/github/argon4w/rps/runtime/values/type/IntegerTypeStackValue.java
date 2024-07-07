package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.values.primitive.WideCharacterStackValue;

public class WideCharacterTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (!(value instanceof IntegerStackValue integerValue)) {
            throw new IllegalStateException("Illegal type");
        }

        return new WideCharacterStackValue((int) integerValue.value());
    }
}
