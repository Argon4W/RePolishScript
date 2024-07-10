package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;

public interface IRuntimeCall {
    void invoke(RuntimeStack stack);
}
