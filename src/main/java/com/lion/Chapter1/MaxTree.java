package com.lion.Chapter1;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;

/**
 * 题目描述：给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree函数
 * arr = {3, 4, 5, 1, 2}
 *      5
 *   4     2
 * 3     1
 *
 * 1.寻找每个数左边第一个比他大的(使用栈)
 * 2.寻找每个数右边第一个比他大的
 */
public class MaxTree {
    public static Map<Node, Node> leftMap;
    public static Map<Node, Node> rightMap;

    public MaxTree() {

    }

    public static void main(String[] args) {
        int[] num = new int[]{3,4,5,1,2};
        Node head = getMaxTree(num);
        System.out.println(head.value);
        System.out.println(head.left.value);
        System.out.println(head.right.value);
    }

    public static Node getMaxTree(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        leftMap = new HashMap<>();
        rightMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Node[] nArr = new Node[num.length];
        for (int i = 0; i < num.length; i++) {
            nArr[i] = new Node(num[i]);
            if (stack.isEmpty()) {
                stack.push(nArr[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().value < num[i]) {
                popStackSetMap(stack, leftMap);
            }
            stack.push(nArr[i]);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, leftMap);
        }

        for (int i = num.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nArr[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().value < num[i]) {
                popStackSetMap(stack, rightMap);
            }
            stack.push(nArr[i]);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rightMap);
        }
        Node head = null;

        for (int i = 0; i < num.length; i++) {
            Node cur = nArr[i];
            Node left = leftMap.get(cur);
            Node right = rightMap.get(cur);
            if (left == null && right == null) {
                head = cur;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = cur;
                } else {
                    right.right = cur;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = cur;
                } else {
                    left.right = cur;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
            }
        }
        return head;
    }

    public static void popStackSetMap(Stack<Node> stack, Map<Node, Node> map) {
        Node top = stack.pop();
        if (stack.isEmpty()) {
            map.put(top, null);
        }else {
            map.put(top, stack.peek());
        }
    }

    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
}
