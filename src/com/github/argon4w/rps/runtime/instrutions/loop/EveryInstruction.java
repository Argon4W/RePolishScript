package com.github.argon4w.rps.runtime.instrutions.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.loop.ILoopStackValue;

import java.util.List;

public class EveryInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReserved();

        if (!(left instanceof RuntimeWrapperStack stackLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (!(right instanceof ILoopStackValue loopRight)) {
            throw new IllegalStateException("Illegal left components");
        }

        List<IStackValue> list = loopRight.getLoopList().stream().map(value -> {
            stackLeft.clear();
            stackLeft.setVariable(loopRight.name().key(), value);
            stackLeft.invoke();

            return stackLeft.popResult();
        }).toList();

        stack.push(new ParalleledStackValue(list));
        return false;
    }
}
