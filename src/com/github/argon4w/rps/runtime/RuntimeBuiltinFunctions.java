package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.runtime.calls.IBuiltinCall;

import java.util.HashMap;

public class RuntimeBuiltinFunctions extends HashMap<String, IBuiltinCall> {
    public void invokeFunction(String key, RuntimeStack stack) {
        IBuiltinCall builtinFunction = get(key);

        if (key == null) {
            throw new IllegalStateException("Illegal builtin function");
        }

        builtinFunction.invoke(stack);
    }
}
