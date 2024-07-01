package com.github.argon4w.rps.runtime.values.primitive;

import com.github.argon4w.rps.runtime.values.IListStackValue;

public interface IStringStackValue extends IAddableStackValue, IEquatableStackValue, IListStackValue, IPrimitiveStackValue {
    String value();
    IntArraySlice codePoints();
}
