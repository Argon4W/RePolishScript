package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ByteStackValue;

public class WriteRuntimeCall implements IRuntimeCall {
    @Override
    public void invoke(RuntimeStack stack) {
        IStackValue value = stack.pop();

        if (!(value instanceof ByteStackValue byteValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        System.out.write(byteValue.value());
    }
}
