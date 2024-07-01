package com.github.argon4w.rps.runtime.instrutions.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.loop.ContinueStackValue;

public class ContinueInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new ContinueStackValue());
        return true;
    }
}
