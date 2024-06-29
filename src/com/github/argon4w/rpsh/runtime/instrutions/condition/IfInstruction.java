package com.github.argon4w.rpsh.runtime.instrutions.condition;

import com.github.argon4w.rpsh.runtime.RuntimeExpressionStack;
import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.RuntimeWrapperStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.ConditionFailedStackValue;
import com.github.argon4w.rpsh.runtime.values.IEndStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;

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
