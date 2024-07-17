package com.github.argon4w.rps.runtime.valuess.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.BooleanStackValue;

import java.util.List;

public record ConditionalLoopStackValue(ILoopStackValue loopValue, RuntimeWrapperStack condition) implements ILoopStackValue {

    @Override
    public List<? extends IStackValue> getLoopList() {
        return loopValue.getLoopList().stream().filter(this::conditionFilter).toList();
    }

    public boolean conditionFilter(IStackValue value) {
        condition.clear();

        condition.setVariable(loopValue.name().key(), value);
        condition.invoke();

        IStackValue result = condition.popResult();

        if (result instanceof RuntimeStack stackValue) {
            result = stackValue.popReturnedResult();
        }

        return result instanceof BooleanStackValue booleanValue && booleanValue.value();
    }

    @Override
    public NameStackValue name() {
        return loopValue.name();
    }
}
