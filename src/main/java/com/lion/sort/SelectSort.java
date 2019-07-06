package com.lion.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,4,5,3,2};
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < array.length ; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
