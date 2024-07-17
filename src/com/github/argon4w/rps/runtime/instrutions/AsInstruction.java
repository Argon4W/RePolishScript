package com.github.argon4w.rps.runtime.instrutions;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.AliasStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;

public class AsInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();
        IStackValue left = stack.pop();

        if (right instanceof NameStackValue nameRight) {
            stack.push(new AliasStackValue(nameRight, left));
            return false;
        }

        if (!(right instanceof ITypeStackValue typeRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        stack.push(typeRight.convert(left));
        return false;
    }
}
