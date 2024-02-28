package ru.gagich;

import java.io.Serial;
import java.io.Serializable;

public class Counter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}