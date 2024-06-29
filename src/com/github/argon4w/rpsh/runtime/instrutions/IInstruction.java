package com.github.argon4w.rpsh.runtime.instrutions;

import com.github.argon4w.rpsh.runtime.RuntimeStack;

public interface IInstruction {
    boolean invoke(RuntimeStack stack);
}
