package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.ListElementStackValue;
import com.github.argon4w.rps.runtime.valuess.slice.ListSliceStackValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListStackValue implements IAddableStackValue, IMultiplierStackValue, IListStackValue {
    public final List<IStackValue> values;

    public ListStackValue() {
        this.values = new ArrayList<>();
    }

    public ListStackValue(List<? extends IStackValue> values) {
        this.values = new ArrayList<>(values);
    }

    public ListStackValue(List<IStackValue> values, IStackValue appendValue) {
        this(values);

        if (appendValue instanceof ListStackValue listValue) {
            this.values.addAll(listValue.values());
            return;
        }

        if (appendValue instanceof ListSliceStackValue sliceValue) {
            this.values.addAll(sliceValue.values());
            return;
        }

        this.values.add(appendValue);
    }

    @Override
    public List<? extends IStackValue> values() {
        return values;
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public IStackValue getRange(IRangeStackValue rangeValue) {
        return getRange(List.of(rangeValue));
    }

    @Override
    public IStackValue getRange(ParalleledStackValue paralleledValue) {
        return getRange(paralleledValue.values);
    }

    public IStackValue getRange(List<IStackValue> values) {
        return new ListStackValue(values.stream().flatMapToInt(this::getIndex).mapToObj(this::get).toList());
    }

    @Override
    public IStackValue getSingle(int index) {
        return new ListElementStackValue(this, index, get(index));
    }

    @Override
    public IStackValue add(IStackValue right) {
        return new ListStackValue(values, right);
    }

    @Override
    public IStackValue multiply(IStackValue right) {
        if (right instanceof ByteStackValue byteRight) {
            return multiply(byteRight.value());
        }

        if (right instanceof IntegerStackValue integerRight) {
            return multiply((int) integerRight.value());
        }

        throw new IllegalStateException("Illegal right components");
    }

    public ListStackValue multiply(int times) {
        if (times == 0) {
            return new ListStackValue();
        }

        if (values.isEmpty()) {
            return new ListStackValue();
        }

        if (times == 1) {
            return new ListStackValue(values);
        }

        ArrayList<IStackValue> list = new ArrayList<>(values.size() * times);

        for (int i = 0; i < times; i ++) {
            list.addAll(values);
        }

        return new ListStackValue(list);
    }

    @Override
    public void set(int index, IStackValue value) {
        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= values.size()) {
            expand(index + 1);
        }

        values.set(index, value);
    }

    public IStackValue get(int index) {
        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= values.size()) {
            expand(index + 1);
        }

        return values.get(index);
    }

    public void expand(int newSize) {
        while (values.size() < newSize) {
            values.add(new UndefinedStackValue());
        }
    }

    public IntStream getIndex(IStackValue value) {
        if (value instanceof IRangeStackValue rangeValue) {
            return rangeValue.getNumbers();
        }

        if (value instanceof ByteStackValue byteValue) {
            return IntStream.of(byteValue.value());
        }

        if (value instanceof IntegerStackValue integerValue) {
            return IntStream.of((int) integerValue.value());
        }

        throw new IllegalStateException("Illegal index");
    }
}
