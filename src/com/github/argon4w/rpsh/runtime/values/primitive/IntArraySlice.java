package com.github.argon4w.rpsh.runtime.values.primitive;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class IntArraySlice {
    public int[] source;
    public int offset;
    public int length;

    public IntArraySlice(int[] source, int offset, int length) {
        this.source = source;
        this.offset = offset;
        this.length = length;
    }

    public IntArraySlice(int value) {
        this(new int[] {value}, 0, 1);
    }

    public IntArraySlice(int[] source) {
        this(source, 0, source.length);
    }

    public IntArraySlice concat(IntArraySlice slice) {
        int[] array = new int[length + slice.length];
        System.arraycopy(source, offset, array, 0, length);
        System.arraycopy(slice.source, slice.offset, array, length, slice.length);

        return new IntArraySlice(array, 0, array.length);
    }

    public IntArraySlice overlap(IntArraySlice slice, int offset) {
        if (offset < 0) {
            throw new IllegalStateException("Illegal offset");
        }

        if (offset >= length) {
            throw new IllegalStateException("Illegal offset");
        }

        int length = Math.max(source.length, slice.source.length + offset);
        int[] array = Arrays.copyOf(source, length);
        System.arraycopy(slice.source, 0, array, offset, slice.source.length);

        return new IntArraySlice(array, 0, length);
    }

    public IntArraySlice slice(int start, int end) {
        if (start < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (end < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (start > end) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (start >= length) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (end > length) {
            throw new IllegalStateException("Illegal bounds");
        }

        return new IntArraySlice(source, offset + start, end - start);
    }

    public void setValue(int index, int value) {
        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= length) {
            throw new IllegalStateException("Illegal bounds");
        }

        source[offset + index] = value;
    }

    public int getValue(int index) {
        if (index < 0) {
            throw new IllegalStateException("Illegal bounds");
        }

        if (index >= length) {
            throw new IllegalStateException("Illegal bounds");
        }

        return source[offset + index];
    }

    public int getLength() {
        return length;
    }

    public int getOffset() {
        return offset;
    }

    public int[] getSource() {
        return source;
    }

    public IntStream stream() {
        return StreamSupport.intStream(Arrays.spliterator(source, offset, offset + length), false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof IntArraySlice that)) {
            return false;
        }

        return Arrays.equals(source, offset, offset + length, that.source, that.offset, that.offset + that.length);
    }
}
