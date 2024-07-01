package com.github.argon4w.rps.runtime.instrutions.object;

import com.github.argon4w.rps.runtime.RuntimeExpressionStack;
import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.values.EmptyStackValue;
import com.github.argon4w.rps.runtime.values.FunctionStackValue;
import com.github.argon4w.rps.runtime.values.IReferencedStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;

public class FunctionInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.popReversed();
        IStackValue left = stack.pop();

        if (right instanceof RuntimeExpressionStack stackRight) {
            right = stackRight.invoke();
        }

        if (right instanceof IReferencedStackValue referenceRight) {
            right = referenceRight.value();
        }

        if (right instanceof FunctionStackValue functionRight) {
            stack.push(functionRight.invoke(left));
            return false;
        }

        if (!(right instanceof RuntimeStack stackRight)) {
            throw new IllegalStateException("Illegal function stack");
        }

        if (left instanceof EmptyStackValue) {
            stack.push(new FunctionStackValue(stackRight));
            return false;
        }

        stack.push(new FunctionStackValue(stackRight, left));
        return false;
    }
}