package com.github.argon4w.rps.lexical;

import com.github.argon4w.rps.lexical.tokens.*;

import java.util.*;

public class SimpleLexicalAnalyzerWithRadix {
    public final SimpleTokenHashMap operatorTokenMap;
    public final SimpleTokenHashMap keywordTokenMap;
    private final List<IToken> tokens;

    public boolean doubleQuotedStringState;
    public boolean singleQuotedStringState;

    public boolean escapeCharacterState;
    public boolean escapeUnicodeState;
    public boolean escapeASCIIState;

    public boolean singleLineCommitState;
    public boolean multiLineCommitState;

    public boolean integerNumberState;
    public boolean binIntegerNumberState;
    public boolean octIntegerNumberState;
    public boolean hexIntegerNumberState;
    public boolean floatingPointNumberState;

    public StringBuffer stringBuffer;
    public StringBuffer escapeBuffer;
    public StringBuffer tokenBuffer;
    public StringBuffer numberBuffer;

    public char[] characters;
    public int index;

    public SimpleLexicalAnalyzerWithRadix(SimpleTokenHashMap operatorTokenMap, SimpleTokenHashMap keywordTokenMap) {
        this.operatorTokenMap = operatorTokenMap;
        this.keywordTokenMap = keywordTokenMap;
        this.tokens = new ArrayList<>();
    }

    public List<IToken> tokenize(String input) {
        doubleQuotedStringState = false;
        singleQuotedStringState = false;

        escapeCharacterState = false;
        escapeUnicodeState = false;
        escapeASCIIState = false;

        singleLineCommitState = false;
        multiLineCommitState = false;

        integerNumberState = false;
        binIntegerNumberState = false;
        octIntegerNumberState = false;
        hexIntegerNumberState = false;
        floatingPointNumberState = false;

        stringBuffer = new StringBuffer();
        escapeBuffer = new StringBuffer();
        tokenBuffer = new StringBuffer();
        numberBuffer = new StringBuffer();

        characters = input.toCharArray();
        index = 0;

        tokens.clear();

        for (; index < characters.length; index ++) {
            if (isSingleLineCommitStateEnter()) {
                singleLineCommitState = true;
                index += 1;
                flushNumberNameKeyword();

                continue;
            }

            if (isMultiLineCommitStateEnter()) {
                singleLineCommitState = false;
                multiLineCommitState = true;
                index += 1;
                flushNumberNameKeyword();

                continue;
            }

            if (isSingleLineCommitStateExit()) {
                singleLineCommitState = false;
                continue;
            }

            if (isMultiLineCommitStateExit()) {
                multiLineCommitState = false;
                index += 1;

                continue;
            }

            if (singleLineCommitState || multiLineCommitState) {
                continue;
            }

            if (characters[index] == '\n') {
                flushNumberNameKeyword();
                continue;
            }

            if (characters[index] == '\r') {
                continue;
            }

            if (isEscapeCharacterExit()) {
                escapeCharacterState = false;
                flushEscapedCharacter();
            }

            if (isEscapeUnicodeExit()) {
                escapeUnicodeState = false;
                flushEscapedUnicode();
            }

            if (isEscapeASCIIExit()) {
                escapeASCIIState = false;
                flushEscapedASCII();
            }

            if (isDoubleQuotedStringStateEnter()) {
                doubleQuotedStringState = true;
                flushNumberNameKeyword();

                continue;
            }

            if (isDoubleQuotedStringStateExit()) {
                doubleQuotedStringState = false;
                flushDoubleQuotedString();

                continue;
            }

            if (isSingleQuotedStringStateEnter()) {
                singleQuotedStringState = true;
                flushNumberNameKeyword();

                continue;
            }

            if (isSingleQuotedStringStateExit()) {
                singleQuotedStringState = false;
                flushSingleQuotedString();

                continue;
            }

            if (isEscapeStateEnter()) {
                escapeCharacterState = true;
                continue;
            }

            if (isEscapeUnicodeStateEnter()) {
                escapeCharacterState = false;
                escapeUnicodeState = true;
                continue;
            }

            if (isEscapeASCIIStateEnter()) {
                escapeCharacterState = false;
                escapeASCIIState = true;
            }

            if (escapeCharacterState || escapeUnicodeState || escapeASCIIState) {
                escapeBuffer.append(characters[index]);
                continue;
            }

            if (doubleQuotedStringState || singleQuotedStringState) {
                stringBuffer.append(characters[index]);
                continue;
            }

            if (characters[index] == ' ') {
                flushNumberNameKeyword();
                continue;
            }

            if (isNumberStateEnter()) {
                flushNumberNameKeyword();
                integerNumberState = true;
            }

            if (isOctIntegerNumberStateEnter()) {
                integerNumberState = false;
                octIntegerNumberState = true;
                continue;
            }

            if (isBinIntegerNumberStateEnter()) {
                octIntegerNumberState = false;
                binIntegerNumberState = true;
                continue;
            }

            if (isHexIntegerNumberStateEnter()) {
                octIntegerNumberState = false;
                hexIntegerNumberState = true;
                continue;
            }

            if (isFloatingPointNumberStateEnter()) {
                integerNumberState = false;
                floatingPointNumberState = true;
            }

            if (isIntegerNumberStateExit()) {
                integerNumberState = false;
                flushIntegerNumber();
            }

            if (isOctIntegerNumberStateExit()) {
                octIntegerNumberState = false;
                flushOctIntegerNumber();
            }

            if (isBinIntegerNumberStateExit()) {
                binIntegerNumberState = false;
                flushBinIntegerNumber();
            }

            if (isHexIntegerNumberStateExit()) {
                hexIntegerNumberState = false;
                flushHexIntegerNumber();
            }

            if (isFloatingPointNumberStateExit()) {
                floatingPointNumberState = false;
                flushFloatingPointNumber();
            }

            if (integerNumberState || floatingPointNumberState || octIntegerNumberState || binIntegerNumberState || hexIntegerNumberState) {
                numberBuffer.append(characters[index]);
                continue;
            }

            String token = getToken();

            if (token != null) {
                flushToken(token);
                continue;
            }

            tokenBuffer.append(characters[index]);
        }

        flushNumberNameKeyword();
        return tokens.stream().filter(Objects::nonNull).toList();
    }

    public void flushNumberNameKeyword() {
        if (integerNumberState) {
            flushIntegerNumber();
        }

        if (binIntegerNumberState) {
            flushBinIntegerNumber();
        }

        if (octIntegerNumberState) {
            flushOctIntegerNumber();
        }

        if (hexIntegerNumberState) {
            flushHexIntegerNumber();
        }

        if (floatingPointNumberState) {
            flushFloatingPointNumber();
        }

        if (isTokenBufferKeyword()) {
            tokens.add(getTokenBufferAsKeyword());
        } else {
            tokens.add(getTokenBufferAsName());
        }

        tokenBuffer = new StringBuffer();
        numberBuffer = new StringBuffer();

        integerNumberState = false;
        octIntegerNumberState = false;
        binIntegerNumberState = false;
        hexIntegerNumberState = false;
        floatingPointNumberState = false;
    }

    public String getToken() {
        return operatorTokenMap.keySet().stream().sorted(Comparator.reverseOrder()).filter(this::equalsSubString).findFirst().orElse(null);
    }

    public boolean equalsSubString(String s) {
        return hasMore(s.length()) && equalsArray(s.toCharArray());
    }

    public boolean equalsArray(char[] c) {
        return Arrays.equals(c, 0, c.length, characters, index, index + c.length);
    }

    public boolean hasMore(int characterCount) {
        return index + (characterCount - 1) < characters.length;
    }

    public void flushToken(String token) {
        flushNumberNameKeyword();
        tokens.add(operatorTokenMap.getToken(token));
        index += (token.length() - 1);
    }

    public boolean isTokenBufferKeyword() {
        return keywordTokenMap.containsKey(tokenBuffer.toString());
    }

    public IToken getTokenBufferAsKeyword() {
        return keywordTokenMap.getToken(tokenBuffer.toString());
    }

    public IToken getTokenBufferAsName() {
        return tokenBuffer.toString().isBlank() ? null : new NameToken(tokenBuffer.toString());
    }

    public void flushFloatingPointNumber() {
        tokens.add(getNumberBufferAsFloatingPointNumber());
        numberBuffer = new StringBuffer();
    }

    public void flushIntegerNumber() {
        tokens.add(getNumberBufferAsIntegerNumber());
        numberBuffer = new StringBuffer();
    }

    public void flushBinIntegerNumber() {
        tokens.add(getNumberBufferAsBinIntegerNumber());
        numberBuffer = new StringBuffer();
    }

    public void flushOctIntegerNumber() {
        tokens.add(getNumberBufferAsOctIntegerNumber());
        numberBuffer = new StringBuffer();
    }

    public void flushHexIntegerNumber() {
        tokens.add(getNumberBufferAsHexIntegerNumber());
        numberBuffer = new StringBuffer();
    }

    public IToken getNumberBufferAsFloatingPointNumber() {
        return new FloatingPointNumberToken(Double.parseDouble(numberBuffer.toString()));
    }

    public IToken getNumberBufferAsIntegerNumber() {
        return new IntegerNumberToken(Long.parseLong(numberBuffer.toString()));
    }

    public IToken getNumberBufferAsBinIntegerNumber() {
        return new IntegerNumberToken(Long.parseLong(numberBuffer.toString(), 2));
    }

    public IToken getNumberBufferAsOctIntegerNumber() {
        return numberBuffer.isEmpty() ? new IntegerNumberToken(0) : new IntegerNumberToken(Long.parseLong(numberBuffer.toString(), 8));
    }

    public IToken getNumberBufferAsHexIntegerNumber() {
        return new IntegerNumberToken(Long.parseLong(numberBuffer.toString(), 16));
    }

    public void flushDoubleQuotedString() {
        tokens.add(new DoubleQuotedStringToken(stringBuffer.toString()));
        stringBuffer = new StringBuffer();
    }

    public void flushSingleQuotedString() {
        tokens.add(new SingleQuotedStringToken(stringBuffer.toString()));
        stringBuffer = new StringBuffer();
    }

    public void flushEscapedCharacter() {
        stringBuffer.append(EscapeCharacters.getEscapeCharacters(escapeBuffer.toString()));
        escapeBuffer = new StringBuffer();
    }

    public void flushEscapedUnicode() {
        stringBuffer.append(getEscapedCodepoint(escapeBuffer.toString(), 16));
        escapeBuffer = new StringBuffer();
    }

    public void flushEscapedASCII() {
        stringBuffer.append(getEscapedCodepoint(escapeBuffer.toString(), 8));
        escapeBuffer = new StringBuffer();
    }

    public String getEscapedCodepoint(String s, int radix) {
        return new String(Character.toChars(Integer.parseInt(s, radix)));
    }

    public boolean isNumberStateEnter() {
        return !integerNumberState && !floatingPointNumberState && !binIntegerNumberState && !octIntegerNumberState && !hexIntegerNumberState && isDecCharacter(characters[index]) && tokenBuffer.isEmpty();
    }

    public boolean isFloatingPointNumberStateEnter() {
        return integerNumberState && isFloatingPointNumberCharacter(characters[index]) && !isRangeOperatorException();
    }

    public boolean isOctIntegerNumberStateEnter() {
        return integerNumberState && numberBuffer.isEmpty() && hasMore(2) && characters[index] == '0' && !isFloatingPointNumberCharacter(characters[index + 1]);
    }

    public boolean isBinIntegerNumberStateEnter() {
        return octIntegerNumberState && numberBuffer.isEmpty() && characters[index] == 'b';
    }

    public boolean isHexIntegerNumberStateEnter() {
        return octIntegerNumberState && numberBuffer.isEmpty() && characters[index] == 'x';
    }

    public boolean isIntegerNumberStateExit() {
        return integerNumberState && (!isDecCharacter(characters[index]) || isRangeOperatorException());
    }

    public boolean isOctIntegerNumberStateExit() {
        return octIntegerNumberState && (!isOctCharacter(characters[index]) || isRangeOperatorException());
    }

    public boolean isBinIntegerNumberStateExit() {
        return binIntegerNumberState && (!isBinCharacter(characters[index]) || isRangeOperatorException());
    }

    public boolean isHexIntegerNumberStateExit() {
        return hexIntegerNumberState && (!isHexCharacter(characters[index]) || isRangeOperatorException());
    }

    public boolean isFloatingPointNumberStateExit() {
        return floatingPointNumberState && !isFloatingPointNumberCharacter(characters[index]) && !isDecCharacter(characters[index]);
    }

    public boolean isRangeOperatorException() {
        return hasMore(2) && characters[index] == '.' && characters[index + 1] == '.';
    }

    public boolean isFloatingPointNumberCharacter(char c) {
        return c == '.' || c == 'e' || c == 'E';
    }

    public boolean isDoubleQuotedStringStateEnter() {
        return !singleQuotedStringState && !singleLineCommitState && !multiLineCommitState && !escapeCharacterState && !doubleQuotedStringState && characters[index] == '\"';
    }

    public boolean isDoubleQuotedStringStateExit() {
        return !singleQuotedStringState && !singleLineCommitState && !multiLineCommitState && !escapeCharacterState && doubleQuotedStringState && characters[index] == '\"';
    }

    public boolean isSingleQuotedStringStateEnter() {
        return !doubleQuotedStringState && !singleLineCommitState && !multiLineCommitState && !escapeCharacterState && !singleQuotedStringState && characters[index] == '\'';
    }

    public boolean isSingleQuotedStringStateExit() {
        return !doubleQuotedStringState && !singleLineCommitState && !multiLineCommitState && !escapeCharacterState && singleQuotedStringState && characters[index] == '\'';
    }

    public boolean isEscapeStateEnter() {
        return !escapeCharacterState && !escapeUnicodeState && !escapeASCIIState && (doubleQuotedStringState | singleQuotedStringState) && characters[index] == '\\';
    }

    public boolean isEscapeUnicodeStateEnter() {
        return escapeCharacterState && !escapeASCIIState && escapeBuffer.isEmpty() && characters[index] == 'u';
    }

    public boolean isEscapeASCIIStateEnter() {
        return escapeCharacterState && !escapeUnicodeState && escapeBuffer.isEmpty() && isOctCharacter(characters[index]);
    }

    public boolean isSingleLineCommitStateEnter() {
        return !singleLineCommitState && !multiLineCommitState && !doubleQuotedStringState && !escapeCharacterState && equalsSubString("//");
    }

    public boolean isSingleLineCommitStateExit() {
        return singleLineCommitState && !doubleQuotedStringState && !escapeCharacterState && characters[index] == '\n';
    }

    public boolean isMultiLineCommitStateEnter() {
        return !multiLineCommitState && !doubleQuotedStringState && !escapeCharacterState && equalsSubString("/*");
    }

    public boolean isMultiLineCommitStateExit() {
        return multiLineCommitState && !doubleQuotedStringState && !escapeCharacterState && equalsSubString("*/");
    }

    public boolean isEscapeUnicodeExit() {
        return escapeUnicodeState && (escapeBuffer.length() >= 6 || !isHexCharacter(characters[index]));
    }

    public boolean isEscapeASCIIExit() {
        return escapeASCIIState && (escapeBuffer.length() >= 3 || !isOctCharacter(characters[index]));
    }

    public boolean isEscapeCharacterExit() {
        return escapeCharacterState && !escapeBuffer.isEmpty();
    }

    public boolean isHexCharacter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    public boolean isOctCharacter(char c) {
        return c >= '0' && c <= '7';
    }

    public boolean isBinCharacter(char c) {
        return c == '0' || c == '1';
    }

    public boolean isDecCharacter(char c) {
        return c >= '0' && c <= '9';
    }
}
