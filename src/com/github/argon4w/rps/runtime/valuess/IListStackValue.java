package com.github.argon4w.rps.runtime.valuess;

import com.github.argon4w.rps.runtime.valuess.primitive.range.IRangeStackValue;

import java.util.List;

public interface IListStackValue extends IStackValue {
    IStackValue getRange(IRangeStackValue rangeValue);
    IStackValue getRange(ParalleledStackValue listValue);
    IStackValue getSingle(int index);
    void set(int index, IStackValue value);
    List<? extends IStackValue> values();
    int size();
}
