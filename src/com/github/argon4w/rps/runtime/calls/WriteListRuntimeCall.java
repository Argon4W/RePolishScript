package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ByteStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ListStackValue;

public class WriteListRuntimeCall implements IRuntimeCall {
    @Override
    public void invoke(RuntimeStack stack) {
        IStackValue value = stack.pop();

        if (!(value instanceof ListStackValue listValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        for (IStackValue elementValue : listValue.values()) {
            if (!(elementValue instanceof ByteStackValue byteValue)) {
                throw new IllegalStateException("Illegal list element");
            }

            System.out.write(byteValue.value());
        }

        System.out.flush();
    }
}
