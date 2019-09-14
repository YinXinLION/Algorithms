package com.lion.domain;

class Stu {

    private int value;

    public Stu(int v){
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Stu [value=" + value + "]";
    }
}
