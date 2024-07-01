package com.github.argon4w.rps.runtime.values.loop;

import com.github.argon4w.rps.runtime.values.ILoopStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.NameStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IRangeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IntegerStackValue;

import java.util.List;

public record LoopRangeStackValue(NameStackValue name, IRangeStackValue value) implements ILoopStackValue {
    public List<? extends IStackValue> getLoopList() {
        return value.getLongNumbers().mapToObj(IntegerStackValue::new).toList();
    }
}
