package com.github.argon4w.rpsh.lexical.tokens.operators;

import com.github.argon4w.rpsh.lexical.IToken;

public interface IOperatorToken extends IToken {
    int getPriority();
}
