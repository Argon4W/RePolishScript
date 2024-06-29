package com.github.argon4w.rpsh.runtime.values.slice;

import com.github.argon4w.rpsh.runtime.values.IPrimitiveStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.*;

import java.util.List;

public record StringSliceStackValue(IntArraySlice slice) implements IStringStackValue {
    @Override
    public String value() {
        return new String(slice.source, slice.offset, slice.length);
    }

    @Override
    public IntArraySlice codePoints() {
        return slice;
    }

    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof WideCharacterStackValue charValue) {
            return new SingleQuotedStringStackValue(slice, charValue.codePoint());
        }

        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(slice, stringStackValue.codePoints());
        }

        if (right instanceof IPrimitiveStackValue primitiveRight) {
            return new SingleQuotedStringStackValue(slice, primitiveRight.getStringValue());
        }

        throw new IllegalStateException("Illegal right components: " + right.getClass().getSimpleName());
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof UndefinedStackValue) {
            return false;
        }

        if (right instanceof IStringStackValue stringValue) {
            return slice.equals(stringValue.codePoints());
        }

        throw new IllegalStateException("Illegal right components");
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

        if (start >= slice.length) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (end > slice.length) {
            throw new IllegalStateException("Illegal bounds");
        }

        return new StringSliceStackValue(slice.slice(start, end));
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

        if (index >= slice.length) {
            throw new IllegalStateException("Illegal bounds");
        }

        return new WideCharacterStackValue(slice.getValue(index));
    }

    @Override
    public void set(int index, IStackValue value) {
        throw new IllegalStateException("Illegal operation");
    }

    @Override
    public List<? extends IStackValue> values() {
        return slice.stream().mapToObj(WideCharacterStackValue::new).toList();
    }

    @Override
    public String getStringValue() {
        return value();
    }
}
