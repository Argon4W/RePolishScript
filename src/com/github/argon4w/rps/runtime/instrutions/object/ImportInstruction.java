package com.github.argon4w.rps.runtime.instrutions.object;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.instrutions.IInstruction;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IStringStackValue;

import java.io.IOException;

public class ImportInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof IStringStackValue stringRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        try {
            stack.push(stack.runtime.importScript(stringRight.value()));
        } catch (IOException exception) {
            throw new IllegalStateException("Illegal imported script file");
        }

        return false;
    }
}
