package com.github.argon4w.rps.runtime.valuess.primitive.range;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IBitOperandStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IEquatableStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SimpleRangeStackValue implements IStackValue, IEquatableStackValue, IRangeStackValue {
    public final IRangeEdgeStackValue start;
    public final IRangeEdgeStackValue end;

    public LongStream cachedLongStream;

    public SimpleRangeStackValue(IRangeEdgeStackValue start, IRangeEdgeStackValue end) {
        this.start = start;
        this.end = end;
    }

    public boolean canBeStepped() {
        return start.value() instanceof IBitOperandStackValue && end.value() instanceof IBitOperandStackValue;
    }

    public boolean isReversed() {
        return start.value().compare(end.value()) > 0;
    }

    @Override
    public boolean isInRange(INumericStackValue value) {
        return isReversed() ? (start.biggerThan(value) && end.smallerThan(value)) : (start.smallerThan(value) && end.biggerThan(value));
    }

    @Override
    public IntStream getNumbers() {
        return getLongNumbers().mapToInt(value -> (int) value);
    }

    @Override
    public LongStream getLongNumbers() {
        if (cachedLongStream != null) {
            return cachedLongStream;
        }

        if (!(start.value() instanceof IBitOperandStackValue bitOperandStart)) {
            throw new IllegalStateException("Illegal range edge");
        }

        if (!(end.value() instanceof IBitOperandStackValue bitOperandEnd)) {
            throw new IllegalStateException("Illegal range edge");
        }

        long startValue = bitOperandStart.getLongValue();
        long endValue = bitOperandEnd.getLongValue();
        long inc = startValue > endValue ? -1 : 1;

        startValue = start instanceof OpenRangeEdgeStackValue ? startValue + inc : startValue;
        endValue = end instanceof ClosedRangeEdgeStackValue ? endValue + inc : endValue;

        long difference = endValue - startValue;
        long size = Math.abs(difference);

        if (size == 0) {
            return LongStream.empty();
        }

        long[] numbers = new long[(int) size];

        for (int i = 0; i < size; i ++) {
            numbers[i] = startValue + inc * i;
        }

        cachedLongStream = LongStream.of(numbers);
        return cachedLongStream;
    }

    @Override
    public boolean equals(IStackValue right) {
        return right instanceof SimpleRangeStackValue rangeValue && start.equals(rangeValue.start) && end.equals(rangeValue.end);
    }

    public IRangeEdgeStackValue start() {
        return start;
    }

    public IRangeEdgeStackValue end() {
        return end;
    }
}
