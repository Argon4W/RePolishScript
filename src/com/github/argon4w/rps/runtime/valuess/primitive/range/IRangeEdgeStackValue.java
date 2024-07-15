package com.github.argon4w.rps.runtime.valuess.primitive.range;

import com.github.argon4w.rps.runtime.valuess.primitive.IEquatableStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

public interface IRangeEdgeStackValue extends IEquatableStackValue {
    INumericStackValue value();
    boolean biggerThan(INumericStackValue value);
    boolean smallerThan(INumericStackValue value);
}
