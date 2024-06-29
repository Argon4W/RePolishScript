package com.github.argon4w.rpsh.runtime.calls;

import com.github.argon4w.rpsh.runtime.RuntimeStack;

public interface IBuiltinCall {
    void invoke(RuntimeStack stack);
}
