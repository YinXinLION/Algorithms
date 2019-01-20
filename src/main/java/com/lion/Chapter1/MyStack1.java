package com.lion.Chapter1;

import java.util.Stack;

/**
 * 实现一个栈中的pop push 和 getMin方法
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin; //记录栈中最小值

    public MyStack1(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty() || newNum <= getMin()) {
            stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int value = this.stackData.pop();
        if (value == getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return this.stackMin.peek();
    }
}
