package com.github.argon4w.rpsh.runtime.values;

import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.RangeStackValue;

import java.util.List;

public interface IListStackValue extends IStackValue {
    IStackValue getRange(RangeStackValue rangeValue);
    IStackValue getRange(ParalleledStackValue listValue);
    IStackValue getSingle(int index);
    void set(int index, IStackValue value);
    List<? extends IStackValue> values();
}
