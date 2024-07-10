package com.github.argon4w.rps.runtime.valuess.loop;

import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;

import java.util.List;

public interface ILoopStackValue extends IStackValue {
    List<? extends IStackValue> getLoopList();
    NameStackValue name();
}
