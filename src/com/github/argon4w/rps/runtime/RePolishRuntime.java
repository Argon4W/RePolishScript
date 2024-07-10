package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.compiler.CompiledScript;
import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.calls.ReadRuntimeCall;
import com.github.argon4w.rps.runtime.calls.WriteListRuntimeCall;
import com.github.argon4w.rps.runtime.calls.WriteRuntimeCall;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class RePolishRuntime {
    public final CompiledScript compiledScript;
    public final RuntimeCalls runtimeCalls;
    public final RuntimeStack rootStack;
    public final HashMap<String, RePolishRuntime> importedScripts;
    public final HashMap<Integer, RuntimeStack> preloadedStacks;

    public RePolishRuntime(CompiledScript compiledScript, RuntimeCalls runtimeCalls) {
        this.compiledScript = compiledScript;
        this.runtimeCalls = runtimeCalls;
        this.importedScripts = new HashMap<>();
        this.preloadedStacks = new HashMap<>();
        this.rootStack = new RuntimeRootStack(compiledScript.getRootStack().instructions(), runtimeCalls, this).initStack(null);
    }

    public RePolishRuntime(CompiledScript compiledScript) {
        this(compiledScript, new RuntimeCalls());

        this.runtimeCalls.put("writeList", new WriteListRuntimeCall());
        this.runtimeCalls.put("write", new WriteRuntimeCall());
        this.runtimeCalls.put("read", new ReadRuntimeCall());
    }

    public void invoke() {
        rootStack.initStack(null).invoke();
    }

    public RuntimeStack requestWrapperStack(RuntimeStack caller, int index) {
        return preloadedStacks.computeIfAbsent(index, i -> new RuntimeWrapperStack(compiledScript.getStack(i).instructions(), runtimeCalls, this)).initStack(caller);
    }

    public RuntimeStack requestExpressionStack(RuntimeStack caller, int index) {
        return preloadedStacks.computeIfAbsent(index, i -> new RuntimeExpressionStack(compiledScript.getStack(i).instructions(), runtimeCalls, this)).initStack(caller);
    }

    public RuntimeStack requestArrayStack(RuntimeStack caller, int index) {
        return new RuntimeArrayStack(compiledScript.getStack(index).instructions(), runtimeCalls, this).initStack(caller);
    }

    public RuntimeStack requestStack(RuntimeStack caller, int index) {
        return new RuntimeStack(compiledScript.getStack(index).instructions(), runtimeCalls, this).initStack(caller);
    }

    public RuntimeStack getRootStack() {
        return this.rootStack;
    }

    public RuntimeStack importScript(String path) throws IOException {
        if (importedScripts.containsKey(path)) {
            return importedScripts.get(path).getRootStack();
        }

        RePolishRuntime runtime = new RePolishRuntime(new RePolishCompiler().compileScript(Path.of(path)), runtimeCalls);
        importedScripts.put(path, runtime);

        return runtime.getRootStack();
    }
}
