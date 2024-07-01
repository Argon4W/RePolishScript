package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IStackValue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface IRangeStackValue extends IStackValue {
    IntStream getNumbers();
    LongStream getLongNumbers();
}
