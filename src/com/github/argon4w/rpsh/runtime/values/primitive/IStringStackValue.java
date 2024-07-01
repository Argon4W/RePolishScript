package com.github.argon4w.rpsh.runtime.values;

import com.github.argon4w.rpsh.runtime.values.primitive.IntArraySlice;

public interface IStringStackValue extends IAddableStackValue, IEquatableStackValue, IListStackValue, IPrimitiveStackValue {
    String value();
    IntArraySlice codePoints();
}
