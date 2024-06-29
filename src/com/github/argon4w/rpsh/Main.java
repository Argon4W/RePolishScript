package com.github.argon4w.rpsh;

import com.github.argon4w.rpsh.runtime.RuntimeStack;

public class Main {
    public static void main(String[] args) throws Throwable {
        RuntimeStack stack = new RePolishRuntime().importRuntimeStack("./rpsh_test_version_1.rpsh");
        stack.invoke();
    }
}