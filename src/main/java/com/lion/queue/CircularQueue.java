package com.lion.queue;

/**
 * 循环队列
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        // head == tail 代表 没有元素
        if (head == tail) {
            return null;
        }
        String res = items[head];
        head = (head + 1) % n;
        return res;
    }
}
