package com.github.argon4w.rps.lexical;

import java.util.HashMap;
import java.util.function.Supplier;

public class SimpleTokenHashMap extends HashMap<String, Supplier<IToken>> {
    public IToken getToken(String key) {
        return containsKey(key) ? get(key).get() : null;
    }
}
