package com.github.argon4w.rpsh.runtime.instrutions.object;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.instrutions.IInstruction;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;
import com.github.argon4w.rpsh.runtime.values.ReturnStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.UndefinedStackValue;

import java.io.IOException;

public class ImportInstruction implements IInstruction {
    @Override
    public boolean invoke(RuntimeStack stack) {
        IStackValue right = stack.pop();

        if (!(right instanceof IStringStackValue stringRight)) {
            throw new IllegalStateException("Illegal right components");
        }

        try {
            stack.push(stack.runtime.importRuntimeStack(stringRight.value()));
        } catch (IOException exception) {
            throw new IllegalStateException("Illegal imported file");
        }

        return false;
    }
}
