package com.github.argon4w.rps.runtime.values.type;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.values.IListStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.ITypeStackValue;
import com.github.argon4w.rps.runtime.values.paralleled.ListStackValue;
import com.github.argon4w.rps.runtime.values.primitive.BooleanStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IRangeStackValue;
import com.github.argon4w.rps.runtime.values.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.values.primitive.SingleQuotedStringStackValue;

import java.util.List;

public class ListTypeStackValue implements ITypeStackValue {
    @Override
    public IStackValue convert(IStackValue value) {
        if (value instanceof RuntimeStack stackValue) {
            return new ListStackValue(stackValue.variableStorage.keySet().stream().map(SingleQuotedStringStackValue::new).toList());
        }

        if (value instanceof IRangeStackValue rangeValue) {
            return new ListStackValue(rangeValue.getLongNumbers().mapToObj(IntegerStackValue::new).toList());
        }

        if (value instanceof IListStackValue) {
            return value;
        }

        throw new IllegalStateException("Illegal type");
    }

    @Override
    public boolean is(IStackValue value) {
        return value instanceof IListStackValue;
    }
}
