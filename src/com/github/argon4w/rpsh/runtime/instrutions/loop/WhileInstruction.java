package com.github.argon4w.rpsh.runtime.instrutions.loop;

import com.github.argon4w.rpsh.runtime.RuntimeExpressionStack;
import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.RuntimeWrapperStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.ReturnStackValue;
import com.github.argon4w.rpsh.runtime.values.loop.BreakStackValue;

public class WhileInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReversed();
        IStackValue left = stack.popReversed();

        if (!(left instanceof RuntimeWrapperStack stackLeft)) {
            throw new IllegalStateException("Illegal condition");
        }

        if (!(right instanceof RuntimeStack stackRight)) {
            throw new IllegalStateException("Illegal loop");
        }

        if (right instanceof RuntimeExpressionStack) {
            throw new IllegalStateException("Illegal loop");
        }

        stackLeft.clear();
        stackLeft.invoke();

        while (stackLeft.popBooleanResult()) {
            stackLeft.clear();
            stackLeft.invoke();

            stackRight.clear();
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
