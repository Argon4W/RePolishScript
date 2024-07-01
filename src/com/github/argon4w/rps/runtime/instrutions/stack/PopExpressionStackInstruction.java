package com.github.argon4w.rps.runtime.instrutions.stack;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;

public class PopExpressionStackInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.pushExpressionStack();
        return false;
    }
}
