package com.github.argon4w.rps;

import com.github.argon4w.rps.runtime.RuntimeStack;

public class Main {
    public static void main(String[] args) throws Throwable {
        RuntimeStack stack = new RePolishRuntime().importRuntimeStack("./rps_test_version_string.rps");
        stack.invoke();
    }
}