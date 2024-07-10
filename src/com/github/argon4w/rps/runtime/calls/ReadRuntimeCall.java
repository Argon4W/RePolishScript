package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.primitive.ByteStackValue;

import java.io.IOException;

public class ReadRuntimeCall implements IRuntimeCall {
    @Override
    public void invoke(RuntimeStack stack) {
        try {
            stack.push(new ByteStackValue((byte) System.in.read()));
        } catch (IOException e) {
            throw new IllegalStateException("Exception in reading stdin");
        }
    }
}
