package com.github.argon4w.rps;

import com.github.argon4w.rps.compiler.CompiledScript;
import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.RePolishRuntime;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Throwable {
        CompiledScript script = new RePolishCompiler().compileScript(Path.of("./rps_test_version_1.rps"));
        RePolishRuntime runtime = new RePolishRuntime(script);
        runtime.invoke();
    }
}