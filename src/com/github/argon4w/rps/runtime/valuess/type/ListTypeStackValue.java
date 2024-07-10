package com.github.argon4w.rps.runtime.valuess.type;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.IListStackValue;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.ITypeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IRangeStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.IntegerStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.ListStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.SingleQuotedStringStackValue;

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
