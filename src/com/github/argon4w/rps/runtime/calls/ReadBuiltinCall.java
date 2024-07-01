package com.github.argon4w.rps.runtime.calls;

import com.github.argon4w.rps.runtime.RuntimeStack;
import com.github.argon4w.rps.runtime.values.primitive.SingleQuotedStringStackValue;

import java.util.Scanner;

public class ReadBuiltinCall implements IBuiltinCall {
    public final Scanner scanner;

    public ReadBuiltinCall() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void invoke(RuntimeStack stack) {
        stack.push(new SingleQuotedStringStackValue(scanner.nextLine()));
    }
}
