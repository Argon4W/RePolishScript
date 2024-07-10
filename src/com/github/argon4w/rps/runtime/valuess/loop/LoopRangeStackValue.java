package com.github.argon4w.rps.runtime.valuess.loop;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;

import java.util.List;

public record LoopRangeStackValue(NameStackValue name, IRangeStackValue value) implements ILoopStackValue {
    public List<? extends IStackValue> getLoopList() {
        return value.getLongNumbers().mapToObj(IntegerStackValue::new).toList();
    }
}
