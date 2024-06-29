package com.github.argon4w.rpsh.runtime.calls;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.values.IPrimitiveStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

public class WriteBuiltinCall implements IBuiltinCall {
    @Override
    public void invoke(RuntimeStack stack) {
        IStackValue value = stack.pop();

        if (!(value instanceof IPrimitiveStackValue primitiveRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        System.out.print(primitiveRight.getStringValue());
    }
}
