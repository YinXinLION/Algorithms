package com.lion.tencent.sort;

public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,5,4,7,8,9};
        countSort(array);
    }

    public static void countSort(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int[] c = new int[max+1];
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            c[array[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i-1] + c[i];
        }
        int[] r = new int[array.length];
        for (int i = array.length-1; i >= 0; i--) {
            int index = c[array[i]] - 1;
            r[index] = array[i];
            c[array[i]]--;
        }
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]+"  ");
        }
    }
}
