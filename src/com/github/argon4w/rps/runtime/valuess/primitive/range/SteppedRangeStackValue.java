package com.github.argon4w.rps.runtime.valuess.primitive.range;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IBitOperandStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IEquatableStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SteppedRangeStackValue implements IStackValue, IEquatableStackValue, IRangeStackValue {
    public final IRangeEdgeStackValue start;
    public final IRangeEdgeStackValue end;
    public final INumericStackValue step;

    public LongStream cachedLongStream;

    public SteppedRangeStackValue(IRangeEdgeStackValue start, IRangeEdgeStackValue end, INumericStackValue step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public boolean isInRange(INumericStackValue value) {
        throw new IllegalStateException("Illegal operation");
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

        if (!(step instanceof IBitOperandStackValue bitOperandStep)) {
            throw new IllegalStateException("Illegal range step");
        }

        long startValue = bitOperandStart.getLongValue();
        long endValue = bitOperandEnd.getLongValue();
        long stepValue = bitOperandStep.getLongValue();
        long edgeInc = startValue > endValue ? -1 : 1;

        startValue = start instanceof OpenRangeEdgeStackValue ? startValue + edgeInc : startValue;
        endValue = end instanceof ClosedRangeEdgeStackValue ? endValue + edgeInc : endValue;

        long difference = endValue - startValue;
        long abs = Math.abs(difference);

        long size = Math.ceilDiv(abs, stepValue);
        long stepInc = difference / abs * stepValue;
        long[] numbers = new long[(int) size];

        for (int i = 0; i < size; i ++) {
            numbers[i] = startValue + stepInc * i;
        }

        cachedLongStream = LongStream.of(numbers);
        return cachedLongStream;
    }

    @Override
    public boolean equals(IStackValue right) {
        return right instanceof SteppedRangeStackValue rangeValue && start.equals(rangeValue.start) && end.equals(rangeValue.end) && step.equals(rangeValue.step);
    }
}
