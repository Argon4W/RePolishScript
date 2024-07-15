package com.github.argon4w.rps.runtime.valuess.loop;

import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;

import java.util.List;

public record LoopListStackValue(NameStackValue name, IListStackValue value) implements ILoopStackValue {
    @Override
    public List<? extends IStackValue> getLoopList() {
        return value.values();
    }
}
