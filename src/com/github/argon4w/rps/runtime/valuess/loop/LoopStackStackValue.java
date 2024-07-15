package com.github.argon4w.rps.runtime.valuess.loop;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.valuess.IStackValue;
import com.github.argon4w.rps.runtime.valuess.NameStackValue;
import com.github.argon4w.rps.runtime.valuess.primitive.SingleQuotedStringStackValue;

import java.util.List;

public record LoopStackStackValue(NameStackValue name, RuntimeStack value) implements ILoopStackValue {
    @Override
    public List<? extends IStackValue> getLoopList() {
        return value.variableStorage.keySet().stream().map(SingleQuotedStringStackValue::new).toList();
    }
}
