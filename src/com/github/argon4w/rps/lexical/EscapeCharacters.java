package com.github.argon4w.rps.lexical;

public class EscapeCharacters {
    public static String getEscapeCharacters(String s) {
        return switch (s) {
            case "t" -> "\t";
            case "b" -> "\b";
            case "f" -> "\f";
            case "n" -> "\n";
            case "r" -> "\r";
            case "s" -> "\s";
            case "\\" -> "\\";
            case "\"" -> "\"";
            case "\'" -> "\'";
            default -> throw new IllegalStateException("Illegal escape character: %s".formatted(s));
        };
    }
}
