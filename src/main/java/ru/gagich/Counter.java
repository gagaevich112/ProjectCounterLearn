package ru.gagich;

import java.io.Serial;
import java.io.Serializable;

public class Counter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public int getCount() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset() {
        value = 0;
    }
}