package com.github.argon4w.rps.runtime.instrutions.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.loop.ConditionalLoopStackValue;
import com.github.argon4w.rps.runtime.valuess.loop.ILoopStackValue;

public class WhenInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReserved();
        IStackValue left = stack.pop();

        if (!(left instanceof ILoopStackValue loopLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (!(right instanceof RuntimeWrapperStack stackRight)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new ConditionalLoopStackValue(loopLeft, stackRight));
        return false;
    }
}
