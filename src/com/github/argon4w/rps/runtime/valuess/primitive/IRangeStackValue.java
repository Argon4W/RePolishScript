package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IStackValue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface IRangeStackValue extends IStackValue {
    IntStream getNumbers();
    LongStream getLongNumbers();
}
