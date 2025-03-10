package com.github.argon4w.rps.runtime.valuess;

import java.util.ArrayList;
import java.util.List;

public class ParameterStackValue implements IStackValue {
    public final List<IStackValue> values;

    public ParameterStackValue(ParalleledStackValue value) {
        this.values = new ArrayList<>(value.values);
    }

    public ParameterStackValue(List<IStackValue> values) {
        this.values = new ArrayList<>(values);
    }
}
