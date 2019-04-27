package com.lion.Chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 获取数组中每个数左边第一个比他大的数
 * 数组中不允许重复
 */
public class GetLeftFirstIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,14,5,4,8,13};
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    leftMap.put(top, null);
                }else {
                    leftMap.put(top, stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                leftMap.put(top, null);
            }else {
                leftMap.put(top, stack.peek());
            }
        }
        System.out.println(leftMap);


        //同理 右边第一个最大 那就从右往左遍历
    }
}
