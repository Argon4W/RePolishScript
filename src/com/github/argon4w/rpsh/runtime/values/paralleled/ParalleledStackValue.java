package com.github.argon4w.rpsh.runtime.values.paralleled;

import com.github.argon4w.rpsh.runtime.values.IStackValue;

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
