package com.github.argon4w.rps.runtime.valuess;

import java.util.ArrayList;
import java.util.List;

public class ParalleledStackValue implements IStackValue {
    public final List<IStackValue> values;

    public ParalleledStackValue(List<IStackValue> values) {
        this.values = new ArrayList<>(values);
    }

    public ParalleledStackValue addRight(IStackValue value) {
        values.add(value);
        return this;
    }
}
