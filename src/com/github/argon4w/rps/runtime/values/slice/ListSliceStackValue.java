package com.github.argon4w.rps.runtime.values.slice;

import com.github.argon4w.rps.runtime.values.IListStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rps.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IAddableStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IRangeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.SimpleRangeStackValue;

import java.util.List;

public record ListSliceStackValue(List<IStackValue> subList) implements IAddableStackValue, IListStackValue {

    @Override
    public IStackValue add(IStackValue right) {
        return new ListStackValue(subList, right);
    }

    @Override
    public IStackValue getRange(IRangeStackValue rangeValue) {
        if (!(rangeValue instanceof SimpleRangeStackValue simpleRangeValue)) {
            throw new IllegalStateException("Illegal range");
        }

        int start = (int) simpleRangeValue.start();
        int end = (int) simpleRangeValue.end();

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

    @Override
    public int size() {
        return subList.size();
    }
}
