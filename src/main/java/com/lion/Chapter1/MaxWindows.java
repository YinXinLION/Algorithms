package com.lion.Chapter1;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 * 队列qmax最前面的一定是最大的
 * qmax ： 6， 4， 3    如果 窗口包含进来一个5，那么会变成6，5
 * 并且会看 6 的下标是否在窗口内，不在的话 踢出6 ，变成 5， 那么窗口最大值为5
 */
public class MaxWindows {
    public int[] getMaxWindows(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length == 0) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
