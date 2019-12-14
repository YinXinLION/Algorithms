package com.lion.tencent.Queue;

public class MyQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public MyQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    // 如果head不为0但是tail已经到最后了，可以使用数组迁移。
    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
