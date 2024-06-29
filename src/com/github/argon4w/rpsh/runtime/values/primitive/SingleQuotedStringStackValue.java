package com.github.argon4w.rpsh.runtime.values.primitive;

import com.github.argon4w.rpsh.runtime.values.IPrimitiveStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.IStringStackValue;
import com.github.argon4w.rpsh.runtime.values.paralleled.ParalleledStackValue;
import com.github.argon4w.rpsh.runtime.values.referenced.ListElementStackValue;

import java.util.List;
import java.util.stream.IntStream;

public class SingleQuotedStringStackValue implements IStringStackValue {
    public IntArraySlice codePoints;

    public SingleQuotedStringStackValue(String value) {
        this.codePoints = new IntArraySlice(value.codePoints().toArray());
    }

    public SingleQuotedStringStackValue(IntArraySlice codePoints) {
        this.codePoints = codePoints;
    }

    public SingleQuotedStringStackValue(IntArraySlice codePoints1, IntArraySlice codePoints2) {
        this.codePoints = codePoints1.concat(codePoints2);
    }

    public SingleQuotedStringStackValue(IntArraySlice codePoints1, int codePoint2) {
        this(codePoints1, new IntArraySlice(codePoint2));
    }

    public SingleQuotedStringStackValue(int codePoint1, IntArraySlice codePoints2) {
        this(new IntArraySlice(codePoint1), codePoints2);
    }

    public SingleQuotedStringStackValue(int codePoint1, int codePoint2) {
        this(new IntArraySlice(codePoint1), new IntArraySlice(codePoint2));
    }

    public SingleQuotedStringStackValue(IntArraySlice codePoints1, String string) {
        this(codePoints1, new IntArraySlice(string.codePoints().toArray()));
    }

    public SingleQuotedStringStackValue(int codePoint1, String string) {
        this(new IntArraySlice(codePoint1), new IntArraySlice(string.codePoints().toArray()));
    }

    @Override
    public String value() {
        return new String(codePoints.source, codePoints.offset, codePoints.length);
    }

    @Override
    public IntArraySlice codePoints() {
        return codePoints;
    }

    @Override
    public IStackValue add(IStackValue right) {
        if (right instanceof WideCharacterStackValue charValue) {
            return new SingleQuotedStringStackValue(codePoints, charValue.codePoint());
        }

        if (right instanceof IStringStackValue stringStackValue) {
            return new SingleQuotedStringStackValue(codePoints, stringStackValue.codePoints());
        }

        if (right instanceof IPrimitiveStackValue primitiveRight) {
            return new SingleQuotedStringStackValue(codePoints, primitiveRight.getStringValue());
        }

        throw new IllegalStateException("Illegal right components: " + right.getClass().getSimpleName());
    }

    @Override
    public boolean equals(IStackValue right) {
        if (right instanceof UndefinedStackValue) {
            return false;
        }

        if (right instanceof IStringStackValue stringValue) {
            return codePoints.equals(stringValue.codePoints());
        }

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public List<? extends IStackValue> values() {
        return codePoints.stream().mapToObj(WideCharacterStackValue::new).toList();
    }

    @Override
    public IStackValue getRange(RangeStackValue rangeValue) {
        return getRange(List.of(rangeValue));
    }

    @Override
    public IStackValue getRange(ParalleledStackValue paralleledValue) {
        return getRange(paralleledValue.values);
    }

    public IStackValue getRange(List<IStackValue> values) {
        return new SingleQuotedStringStackValue(new IntArraySlice(values.stream().flatMapToInt(this::getIndex).map(index -> codePoints.getValue(index)).toArray()));
    }

    @Override
    public IStackValue getSingle(int index) {
        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= codePoints.length) {
            throw new IllegalStateException("Illegal bounds");
        }

        return new ListElementStackValue(this, index, new WideCharacterStackValue(codePoints.getValue(index)));
    }

    @Override
    public void set(int index, IStackValue value) {
        if (!(value instanceof IStringStackValue stringValue)) {
            throw new IllegalStateException("Illegal character");
        }

        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= codePoints.length) {
            throw new IllegalStateException("Illegal bounds");
        }

        codePoints = codePoints.overlap(stringValue.codePoints(), index);
    }

    public IntStream getIndex(IStackValue value) {
        if (value instanceof IntegerStackValue integerValue) {
            return IntStream.of((int) integerValue.value());
        }

        if (!(value instanceof RangeStackValue rangeValue)) {
            throw new IllegalStateException("Illegal index");
        }

        int start = (int) rangeValue.min();
        int end = (int) rangeValue.max();

        if (start < 0) {
            throw new IllegalStateException("Illegal index");
        }

        if (end < 0) {
            throw new IllegalStateException("Illegal index");
        }

        if (start > end) {
            throw new IllegalStateException("Illegal index");
        }

        return IntStream.range(start, end);
    }

    @Override
    public String getStringValue() {
        return value();
    }
}
