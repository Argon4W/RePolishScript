package com.github.argon4w.rps.runtime.values.paralleled;

import com.github.argon4w.rps.runtime.values.IStackValue;

import java.util.ArrayList;
import java.util.List;

public class ParameterStackValue implements IStackValue {
    public final List<IStackValue> values;

    public ParameterStackValue(ParalleledStackValue value) {
        this.values = new ArrayList<>(value.values);
    }
}
