package com.lion.tencent.stack;

public class MyStack {
    private String[] s;
    private int count;//元素个数
    private int n;//栈的大小

    public MyStack(int n) {
        this.s = new String[n];
        this.count = 0;
        this.n = n;
    }

    public boolean push(String item) {
        if (count == n) {
            return false;
        }
        s[count] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String temp = s[count-1];
        --count;
        return temp;
    }
}
