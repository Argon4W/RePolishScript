package com.github.argon4w.rps.runtime.instrutions.object;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.IReferencedStackValue;

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
