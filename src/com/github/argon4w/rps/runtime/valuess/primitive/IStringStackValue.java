package com.github.argon4w.rps.runtime.valuess.primitive;

import com.github.argon4w.rps.runtime.valuess.IListStackValue;

public interface IStringStackValue extends IAddableStackValue, IEquatableStackValue, IListStackValue, IPrimitiveStackValue {
    String value();
    IntArraySlice codePoints();
}
