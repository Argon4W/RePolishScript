package com.github.argon4w.rps.runtime.valuess.slice;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.*;

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
        return right instanceof IStringStackValue stringValue && slice.equals(stringValue.codePoints());
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
    public int size() {
        return slice.getLength();
    }

    @Override
    public String getStringValue() {
        return value();
    }
}
