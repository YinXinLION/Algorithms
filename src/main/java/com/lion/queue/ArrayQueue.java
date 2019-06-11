package com.lion.queue;

public class ArrayQueue {
    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) return false;
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 由于item入队 tail已经是最后，但有可能前面还会有空闲空间，
     * 那么进行一次数组搬移工作
     * 时间复杂度分摊导致入队仍为O(1)
     * @param item
     * @return
     */
    public boolean enqueue_new1(String item) {
        if (tail == n) {
            if (head == 0) return false;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            //更新 head 、 tail
            head = 0;
            tail = tail - head;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }


}
