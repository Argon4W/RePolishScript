package com.github.argon4w.rpsh.runtime.instrutions.stack;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;

public class PopStackInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.pushStack();
        return false;
    }
}
