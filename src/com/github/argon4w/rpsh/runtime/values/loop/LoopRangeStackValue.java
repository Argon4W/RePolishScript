package com.github.argon4w.rpsh.runtime.values.loop;

import com.github.argon4w.rpsh.runtime.values.ILoopStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.RangeStackValue;

import java.util.List;
import java.util.stream.LongStream;

public record LoopRangeStackValue(NameStackValue name, RangeStackValue value) implements ILoopStackValue {
    public List<? extends IStackValue> getLoopList() {
        return LongStream.range(value.min(), value.max()).mapToObj(IntegerStackValue::new).toList();
    }
}
