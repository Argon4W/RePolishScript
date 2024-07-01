package com.github.argon4w.rps.runtime.instrutions.condition;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.ConditionFailedStackValue;
import com.github.argon4w.rps.runtime.values.IEndStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;

public class ElseInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReversed();
        IStackValue left = stack.popReversed();

        if (!(right instanceof RuntimeWrapperStack stackRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        if (!(left instanceof RuntimeWrapperStack stackLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stackLeft.invoke();
        IStackValue stackResultLeft = stackLeft.popResult();

        if (stackResultLeft instanceof RuntimeStack stackValue) {
            stackResultLeft = stackValue.popResult();
        }

        if (!(stackResultLeft instanceof ConditionFailedStackValue)) {
            stack.push(stackResultLeft);
            return stackResultLeft instanceof IEndStackValue;
        }

        stackRight.invoke();
        IStackValue stackResultRight = stackRight.popResult();

        if (stackResultRight instanceof RuntimeStack stackValue) {
            stackResultRight = stackValue.popResult();
        }

        stack.push(stackResultRight);
        return stackResultRight instanceof IEndStackValue;
    }
}
