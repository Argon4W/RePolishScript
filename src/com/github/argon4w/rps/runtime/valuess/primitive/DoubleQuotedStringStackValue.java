package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ParalleledStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.range.IRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.referenced.ListElementStackValue;

import java.util.List;
import java.util.stream.IntStream;

public class DoubleQuotedStringStackValue implements IStringStackValue {
    public IntArraySlice codePoints;

    public DoubleQuotedStringStackValue(String value) {
        this.codePoints = new IntArraySlice(value.codePoints().toArray());
    }

    public DoubleQuotedStringStackValue(IntArraySlice codePoints) {
        this.codePoints = codePoints;
    }

    public DoubleQuotedStringStackValue(IntArraySlice codePoints1, IntArraySlice codePoints2) {
        this.codePoints = codePoints1.concat(codePoints2);
    }

    public DoubleQuotedStringStackValue(IntArraySlice codePoints1, int codePoint2) {
        this(codePoints1, new IntArraySlice(codePoint2));
    }

    public DoubleQuotedStringStackValue(int codePoint1, IntArraySlice codePoints2) {
        this(new IntArraySlice(codePoint1), codePoints2);
    }

    public DoubleQuotedStringStackValue(int codePoint1, int codePoint2) {
        this(new IntArraySlice(codePoint1), new IntArraySlice(codePoint2));
    }

    public DoubleQuotedStringStackValue(IntArraySlice codePoints1, String string) {
        this(codePoints1, new IntArraySlice(string.codePoints().toArray()));
    }

    public DoubleQuotedStringStackValue(int codePoint1, String string) {
        this(new IntArraySlice(codePoint1), new IntArraySlice(string.codePoints().toArray()));
    }

    public DoubleQuotedStringStackValue(String string, int codePoint2) {
        this(new IntArraySlice(string.codePoints().toArray()), new IntArraySlice(codePoint2));
    }

    @Override
    public String value() {
        return new String(codePoints.source, 0, codePoints.length);
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

        throw new IllegalStateException("Illegal right components");
    }

    @Override
    public boolean equals(IStackValue right) {
        return right instanceof IStringStackValue stringValue && codePoints.equals(stringValue.codePoints());
    }

    @Override
    public List<? extends IStackValue> values() {
        return codePoints.stream().mapToObj(WideCharacterStackValue::new).toList();
    }

    @Override
    public int size() {
        return codePoints.getLength();
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

        if (!(value instanceof IRangeStackValue rangeValue)) {
            throw new IllegalStateException("Illegal index");
        }

        return rangeValue.getNumbers();
    }

    @Override
    public String getStringValue() {
        return value();
    }
}