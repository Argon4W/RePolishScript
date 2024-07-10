package com.github.argon4w.rps.runtime.instrutions.object;

import com.github.argon4w.rps.runtime.RuntimeExpressionStack;
import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.BooleanStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IStringStackValue;

public class HasInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(left instanceof RuntimeStack stackLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (left instanceof RuntimeExpressionStack) {
            throw new IllegalStateException("Illegal left components");
        }

        if (!(right instanceof IStringStackValue stringRight)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new BooleanStackValue(stackLeft.variableStorage.containsKey(stringRight.value())));
        return false;
    }
}
