package com.github.argon4w.rpsh.runtime.values.slice;

import com.github.argon4w.rpsh.runtime.values.IAddableStackValue;
import com.github.argon4w.rpsh.runtime.values.IListStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.RangeStackValue;

import java.util.List;

public record ListSliceStackValue(List<IStackValue> subList) implements IAddableStackValue, IListStackValue {

    @Override
    public IStackValue add(IStackValue right) {
        return new ListStackValue(subList, right);
    }

    @Override
    public IStackValue getRange(RangeStackValue rangeValue) {
        int start = (int) rangeValue.min();
        int end = (int) rangeValue.max();

        if (start < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (end < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (start > end) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (start >= subList.size()) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (end > subList.size()) {
            throw new IllegalStateException("Illegal bounds");
        }

        return new ListSliceStackValue(subList.subList(start, end));
    }

    @Override
    public IStackValue getRange(ParalleledStackValue listValue) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public IStackValue getSingle(int index) {
        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= subList.size()) {
            throw new IllegalStateException("Illegal bounds");
        }

        return subList.get(index);
    }

    @Override
    public void set(int index, IStackValue value) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public List<? extends IStackValue> values() {
        return subList;
    }
}
