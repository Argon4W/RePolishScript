package com.github.argon4w.rps.runtime.values;

import java.util.List;

public interface ILoopStackValue extends IStackValue {
    List<? extends IStackValue> getLoopList();
    NameStackValue name();
}
