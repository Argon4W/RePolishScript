package com.github.argon4w.rpsh.runtime.instrutions.object;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IReferencedStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;

public class OfInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (!(right instanceof NameStackValue nameRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        if (left instanceof NameStackValue nameLeft) {
            left = nameLeft.getValue();
        }

        if (left instanceof IReferencedStackValue referencedLeft) {
            left = referencedLeft.value();
        }

        if (!(left instanceof RuntimeStack stackLeft)) {
            throw new IllegalStateException("Illegal left components");
        }

        stack.push(new NameStackValue(nameRight.key(), stackLeft));
        return false;
    }
}
