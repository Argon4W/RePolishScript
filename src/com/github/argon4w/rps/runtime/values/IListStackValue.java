package com.github.argon4w.rps.runtime.values;

import com.github.argon4w.rps.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IRangeStackValue;

import java.util.List;

public interface IListStackValue extends IStackValue {
    IStackValue getRange(IRangeStackValue rangeValue);
    IStackValue getRange(ParalleledStackValue listValue);
    IStackValue getSingle(int index);
    void set(int index, IStackValue value);
    List<? extends IStackValue> values();
    int size();
}
