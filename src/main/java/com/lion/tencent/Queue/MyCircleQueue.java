package com.lion.tencent.Queue;

/**
 * 循环队列
 */
public class MyCircleQueue {
    private String[] items;//数组
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public MyCircleQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    public boolean enqueue(String item) {
        //队列满了
        if ((tail+1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail+1)%n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head+1) %n;
        return ret;
    }

}
