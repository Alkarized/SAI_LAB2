package com.company;

public class ValueIDX {
    private final Integer value;
    private final Integer idx;

    public ValueIDX(Integer value, Integer idx) {
        this.value = value;
        this.idx = idx;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getIdx() {
        return idx;
    }
}
