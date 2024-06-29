package com.github.argon4w.rpsh.runtime.values.loop;

import com.github.argon4w.rpsh.runtime.values.IListStackValue;
import com.github.argon4w.rpsh.runtime.values.ILoopStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;

import java.util.List;

public record LoopListStackValue(NameStackValue name, IListStackValue value) implements ILoopStackValue {
    public List<? extends IStackValue> getLoopList() {
        return value.values();
    }
}
