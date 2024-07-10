package com.github.argon4w.rps.runtime.instrutions.condition;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IEndStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ConditionFailedStackValue;

public class IfInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReversed();
        IStackValue left = stack.pop();

        if (!(left instanceof RuntimeWrapperStack stackLeft)) {
            throw new IllegalStateException("Illegal condition");
        }

        if (!(right instanceof RuntimeStack stackRight)) {
            throw new IllegalStateException("Illegal result");
        }

        stackLeft.invoke();

        if (!stackLeft.popBooleanResult()) {
            stack.push(new ConditionFailedStackValue());
            return false;
        }

        stackRight.invoke();
        IStackValue result = stackRight.popResult();

        if (result instanceof RuntimeStack stackValue) {
            result = stackValue.popResult();
        }

        stack.push(result);
        return result instanceof IEndStackValue;
    }
}
