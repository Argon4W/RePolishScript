package com.github.argon4w.rpsh.runtime.instrutions.stack;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;

public class PopArrayStackInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.pushArrayStack();
        return false;
    }
}
