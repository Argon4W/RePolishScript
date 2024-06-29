package com.github.argon4w.rpsh.runtime.instrutions.loop;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.loop.ContinueStackValue;

public class ContinueInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new ContinueStackValue());
        return true;
    }
}
