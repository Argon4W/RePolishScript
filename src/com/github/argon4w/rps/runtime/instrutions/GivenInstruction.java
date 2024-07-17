package com.github.argon4w.rps.runtime.instrutions;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.valuess.AliasStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;

public class GivenInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.popReserved();

        if (!(left instanceof RuntimeWrapperStack stackLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        if (!(right instanceof AliasStackValue aliasRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stackLeft.setVariable(aliasRight.name().key(), aliasRight.value());
        stackLeft.invoke();

        IStackValue result = stackLeft.popResult();

        if (result instanceof RuntimeStack stackValue) {
            result = stackValue.popReturnedResult();
        }

        stack.push(result);
        return false;
    }
}
