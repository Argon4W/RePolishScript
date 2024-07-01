package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;

public interface IBuiltinCall {
    void invoke(RuntimeStack stack);
}
