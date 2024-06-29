package com.github.argon4w.rpsh.runtime.values.loop;

import com.github.argon4w.rpsh.runtime.RuntimeStack;
import com.github.argon4w.rpsh.runtime.values.ILoopStackValue;
import com.github.argon4w.rpsh.runtime.values.IStackValue;
import com.github.argon4w.rpsh.runtime.values.NameStackValue;
import com.github.argon4w.rpsh.runtime.values.primitive.SingleQuotedStringStackValue;

import java.util.List;

public record LoopStackStackValue(NameStackValue name, RuntimeStack value) implements ILoopStackValue {
    public List<? extends IStackValue> getLoopList() {
        return value.variableStorage.keySet().stream().map(SingleQuotedStringStackValue::new).toList();
    }
}
