package com.github.argon4w.rps.runtime.values.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.values.ILoopStackValue;
import com.github.argon4w.rps.runtime.values.IStackValue;
import com.github.argon4w.rps.runtime.values.NameStackValue;
import com.github.argon4w.rps.runtime.values.primitive.SingleQuotedStringStackValue;

import java.util.List;

public record LoopStackStackValue(NameStackValue name, RuntimeStack value) implements ILoopStackValue {
    public List<? extends IStackValue> getLoopList() {
        return value.variableStorage.keySet().stream().map(SingleQuotedStringStackValue::new).toList();
    }
}
