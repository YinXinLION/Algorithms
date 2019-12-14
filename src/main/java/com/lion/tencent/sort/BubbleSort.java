package com.lion.tencent.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            //提前推出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            // 如果没有交换 提前结束
            if (!flag) {
                return;
            }
        }
    }
}
