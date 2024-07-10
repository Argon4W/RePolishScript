package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.calls.IRuntimeCall;

import java.util.HashMap;

public class RuntimeCalls extends HashMap<String, IRuntimeCall> {
    public void invokeFunction(String key, RuntimeStack stack) {
        if (!containsKey(key)) {
            throw new IllegalStateException("Illegal builtin function");
        }

        get(key).invoke(stack);
    }
}
