package com.github.argon4w.rps.runtime.valuess.primitive.range;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.INumericStackValue;

public record OpenRangeEdgeStackValue(INumericStackValue value) implements IRangeEdgeStackValue {
    @Override
    public boolean biggerThan(INumericStackValue value) {
        return this.value.compare(value) > 0;
    }

    @Override
    public boolean smallerThan(INumericStackValue value) {
        return this.value.compare(value) < 0;
    }

    @Override
    public boolean equals(IStackValue right) {
        return right instanceof OpenRangeEdgeStackValue edgeValue && value.equals(edgeValue.value);
    }
}
