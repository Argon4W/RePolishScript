package com.github.argon4w.rps.runtime.valuess.loop;

import com.github.argon4w.rps.runtime.RuntimeWrapperStack;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;

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

        return condition.popBooleanResult();
    }

    @Override
    public NameStackValue name() {
        return loopValue.name();
    }
}
