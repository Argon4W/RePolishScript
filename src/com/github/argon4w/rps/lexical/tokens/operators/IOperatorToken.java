package com.github.argon4w.rps.lexical.tokens.operators;

import com.github.argon4w.rps.lexical.IToken;

public interface IOperatorToken extends IToken {
    int getPriority();
}
