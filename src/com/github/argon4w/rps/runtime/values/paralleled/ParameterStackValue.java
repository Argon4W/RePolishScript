package com.github.argon4w.rps.runtime.values.paralleled;

public class ParameterStackValue extends ParalleledStackValue {
    public ParameterStackValue(ParalleledStackValue value) {
        super(value.values);
    }
}
