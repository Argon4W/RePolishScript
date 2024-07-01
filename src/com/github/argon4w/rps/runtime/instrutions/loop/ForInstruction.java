package com.github.argon4w.rps.runtime.instrutions.loop;

import com.github.argon4w.rps.runtime.RuntimeExpressionStack;
import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.ILoopStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.NameStackValue;
import com.github.argon4w.rps.runtime.values.ReturnStackValue;
import com.github.argon4w.rps.runtime.values.loop.BreakStackValue;

import java.util.List;

public class ForInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReversed();
        IStackValue left = stack.pop();

        if (!(left instanceof ILoopStackValue loopLeft)) {
            throw new IllegalStateException("Illegal condition");
        }

        if (!(right instanceof RuntimeStack stackRight)) {
            throw new IllegalStateException("Illegal loop");
        }

        if (right instanceof RuntimeExpressionStack) {
            throw new IllegalStateException("Illegal loop");
        }

        List<? extends IStackValue> list = loopLeft.getLoopList();
        NameStackValue nameValue = loopLeft.name();

        for (IStackValue value : list) {
            stackRight.clear();
            stackRight.setVariable(nameValue.key(), value);

            stackRight.invoke();
            IStackValue result = stackRight.popResult();

            if (result instanceof BreakStackValue) {
                break;
            }

            if (result instanceof ReturnStackValue) {
                stack.push(result);
                return true;
            }
        }

        return false;
    }
}