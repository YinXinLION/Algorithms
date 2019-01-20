package com.lion.Chapter1;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 */
public class TwoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackpop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackpop = new Stack<Integer>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackpop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackpop.empty()) {
            while (!stackPush.isEmpty()) {
                stackpop.push(stackPush.pop());
            }
        }
        return stackpop.pop();
    }

    public int peek() {
        if (stackpop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackpop.empty()) {
            while (!stackPush.isEmpty()) {
                stackpop.push(stackPush.pop());
            }
        }
        return stackpop.peek();
    }
}
