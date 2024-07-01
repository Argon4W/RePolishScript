package com.github.argon4w.rps.runtime.instrutions;

import com.github.argon4w.rps.runtime.RuntimeStack;

public interface IInstruction {
    boolean invoke(RuntimeStack stack);
}
