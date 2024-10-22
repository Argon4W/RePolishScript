package com.github.argon4w.rps.runtime.valuess.slice;

import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IAddableStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IBitOperandStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ListStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.IRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.SimpleRangeStackValue;

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

        if (!(simpleRangeValue.start() instanceof IBitOperandStackValue bitOperandStart)) {
            throw new IllegalStateException("Illegal range edge");
        }

        if (!(simpleRangeValue.end() instanceof IBitOperandStackValue bitOperandEnd)) {
            throw new IllegalStateException("Illegal range edge");
        }

        int start = (int) bitOperandStart.getLongValue();
        int end = (int) bitOperandEnd.getLongValue();

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
