package com.github.argon4w.rps.runtime.instrutions.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.loop.BreakStackValue;

public class BreakInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        stack.push(new BreakStackValue());
        return true;
    }
}
