package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public record SteppedRangeStackValue(long start, long end, long step) implements IStackValue, IEquatableStackValue, IPrimitiveStackValue, IRangeStackValue {
    @Override
    public IntStream getNumbers() {
        return getLongNumbers().mapToInt(value -> (int) value);
    }

    @Override
    public LongStream getLongNumbers() {
        long difference = end - start;
        long abs = Math.abs(difference);
        long size = Math.ceilDiv(abs, step);
        long inc = difference / abs * step;
        long[] numbers = new long[(int) size];

        for (int i = 0; i < size; i ++) {
            numbers[i] = start + inc * i;
        }

        return LongStream.of(numbers);
    }

    @Override
    public boolean equals(IStackValue right) {
        return right instanceof SteppedRangeStackValue rangeValue && start == rangeValue.start && end == rangeValue.end && step == rangeValue.step;
    }

    @Override
    public String getStringValue() {
        return start + ".." + end;
    }
}
