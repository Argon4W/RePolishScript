package com.github.argon4w.rpsh.runtime.values;

import java.util.List;

public interface ILoopStackValue extends IStackValue {
    List<? extends IStackValue> getLoopList();
    NameStackValue name();
}
