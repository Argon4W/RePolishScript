package com.github.argon4w.rps.runtime;

import com.github.argon4w.rps.compiler.CompiledScript;
import com.github.argon4w.rps.compiler.RePolishCompiler;
import com.github.argon4w.rps.runtime.calls.ReadRuntimeCall;
import com.github.argon4w.rps.runtime.calls.WriteRuntimeCall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class RePolishRuntime {
    public final CompiledScript compiledScript;
    public final RuntimeCalls runtimeCalls;
    public final RuntimeStack rootStack;
    public final HashMap<Integer, RePolishRuntime> importedScripts;
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

        this.runtimeCalls.put("write", new WriteRuntimeCall());
        this.runtimeCalls.put("read", new ReadRuntimeCall());
    }

    public void invoke() {
        rootStack.initStack(null).invoke();
    }

    //May not work when multithreading cuz all stacks requested are the same object. But it works great on a single thread
    public RuntimeStack requestWrapperStack(RuntimeStack caller, int index) {
        return preloadedStacks.computeIfAbsent(index, i -> new RuntimeWrapperStack(compiledScript.getStack(i).instructions(), runtimeCalls, this)).initStack(caller);
    }

    public RuntimeStack requestArrayStack(RuntimeStack caller, int index) {
        return preloadedStacks.computeIfAbsent(index, i -> new RuntimeArrayStack(compiledScript.getStack(i).instructions(), runtimeCalls, this)).initStack(caller);
    }

    public RuntimeStack requestExpressionStack(RuntimeStack caller, int index) {
        return preloadedStacks.computeIfAbsent(index, i -> new RuntimeExpressionStack(compiledScript.getStack(i).instructions(), runtimeCalls, this)).initStack(caller);
    }

    public RuntimeStack requestStack(RuntimeStack caller, int index) {
        return preloadedStacks.computeIfAbsent(index, i -> new RuntimeStack(compiledScript.getStack(i).instructions(), runtimeCalls, this)).initStack(caller);
    }

    public RuntimeStack importScript(String path) throws IOException {
        String string = Files.readString(Path.of(path));
        return importedScripts.computeIfAbsent(path.hashCode(), i -> new RePolishRuntime(new RePolishCompiler().compileScript(string), runtimeCalls)).getRootStack();
    }

    public RuntimeStack getRootStack() {
        return this.rootStack;
    }
}
