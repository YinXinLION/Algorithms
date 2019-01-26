package com.lion.Chapter1;

import java.util.Stack;

public class ReserveStack {
    private static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    /**
     * 递归的删除且获取栈底元素
     * 当栈为null，返回pop出的元素
     * 否则 继续取
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElemet(Stack<Integer> stack) {
        int s = stack.pop();
        if (stack.peek() == null) {
            return s;
        } else {
            int result = getAndRemoveLastElemet(stack);
            stack.push(s);
            return result;
        }
    }

    /**
     * 栈反转
     * 如果栈为null停止反转
     * 先获取栈底元素，然后继续获取，
     *
     * @param stack
     */
    public static void reserve(Stack<Integer> stack){
        if (stack.peek() == null) {
            return;
        } else {
            int result = getAndRemoveLastElemet(stack);
            reserve(stack);
            stack.push(result);
        }
    }
}
