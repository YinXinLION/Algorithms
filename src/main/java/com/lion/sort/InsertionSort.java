package com.lion.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {

    }

    public void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            int value = a[i];
            int j = i - 1;
            for (;j >= 0; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
