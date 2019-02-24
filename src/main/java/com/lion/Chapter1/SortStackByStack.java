package com.lion.Chapter1;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序 （stack要求栈顶到栈底大到小， help则为小到大）
 *
 * 每次stack pop 一个元素 记为cur
 * cur 小于或等于help栈顶，直接将cur放入help
 * cur大于help栈顶，将大于栈顶的pop并放入stack中，最后将cur压入help，
 *
 * 最后将help导入到stack
 */
public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
