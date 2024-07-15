package com.github.argon4w.rps.runtime.valuess.primitive.range;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface IRangeStackValue extends IStackValue {
    boolean isInRange(INumericStackValue value);
    IntStream getNumbers();
    LongStream getLongNumbers();
}
