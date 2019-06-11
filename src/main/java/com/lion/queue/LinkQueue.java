package com.lion.queue;

import com.lion.chapter2.Node;

public class LinkQueue {
    Node head;
    Node tail;
    public boolean enqueue(Node p) {
        if (head == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = tail.next;
        }
        return true;
    }

    public Node dequeue() {
        if (head == null && tail == null) {
            return null;
        } else {
            Node p = head;
            head = head.next;
            return p;
        }
    }
}
