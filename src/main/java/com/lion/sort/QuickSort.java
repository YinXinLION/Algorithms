package com.lion.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] s = new int[]{2,5,1,3,7,4,10,8,11 };
        quick_sort(s);
        for (int i : s) {
            System.out.println(i);
        }
    }

    public static void quick_sort(int[] s) {
        quick_sort_c(s, 0, s.length-1);
    }

    public static void quick_sort_c(int[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = quick_sort_left_right(s, left, right);
        quick_sort_c(s, left, i-1);
        quick_sort_c(s, i, right);
    }

    public static int  quick_sort_left_right(int[] s, int left, int right) {
        int pivot = right;
        int i = left;
        for (int j = left; j <= right; j++) {
            if (s[j] < s[pivot]) {
                int temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
            }
        }
        if (i < right) {
            int temp = s[pivot];
            s[pivot] = s[i];
            s[i] = temp;
        }
        return i;
    }
}
