package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.values.IListStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.primitive.ByteStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IPrimitiveStackValue;

public class WriteBuiltinCall implements IBuiltinCall {
    @Override
    public void invoke(RuntimeStack stack) {
        IStackValue value = stack.pop();

        if (!(value instanceof ByteStackValue byteValue)) {
            throw new IllegalStateException("Illegal right components");
        }

        System.out.write(byteValue.value());
    }
}
