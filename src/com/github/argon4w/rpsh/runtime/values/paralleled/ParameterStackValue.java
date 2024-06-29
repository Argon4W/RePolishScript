package com.github.argon4w.rpsh.runtime.values.paralleled;

public class ParameterStackValue extends ParalleledStackValue {
    public ParameterStackValue(ParalleledStackValue value) {
        super(value.values);
    }
}
