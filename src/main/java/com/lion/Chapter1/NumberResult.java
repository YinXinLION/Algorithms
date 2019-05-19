package com.lion.Chapter1;

import java.util.LinkedList;

/**
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
 * max(arr[i..j]) - min(arr[i..j]) <= num
 */
public class NumberResult {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5};
        System.out.println(getAll(arr, 1));
    }

    /**
     * 1.对于max(arr[i..j])， max(arr[i..j-1])肯定小于等于max(arr[i..j])
     * 2.对于min(arr[i..j])，min(arr[i..j-1])肯定大于等于min(arr[i..j]
     * 那么max(arr[i..j]) - min(arr[i..j] <= num 成立
     * 那么max(arr[i..j-1]) - min(arr[i..j-1] <= num 及子范围也一定成立
     *
     * 如果不成立 ，那么子范围的一定不成立
     * @param arr
     * @param num
     * @return
     */
    public static int getAll(int[] arr, int num) {
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int res = 0;
        int jj = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                jj = j;
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += jj - i;
        }
        return res;
    }
}
