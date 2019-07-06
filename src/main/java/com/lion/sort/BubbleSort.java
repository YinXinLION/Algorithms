package com.lion.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,4,5,3,2};
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false; //优化
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;//当数据没有交换时提前退出
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
