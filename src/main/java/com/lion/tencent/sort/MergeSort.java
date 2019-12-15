package com.lion.tencent.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {

    }

    public static void merge(int[] s, int n) {
        merge_sort1(s, 0 , n-1);
    }

    public static void merge_sort1(int[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge_sort1(s, left, mid);
        merge_sort1(s, mid+1, right);
        merge_partition(s, left, mid, right);
    }
    public static void merge_partition(int[] s, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (s[i] <= s[j]) {
                temp[k++] = s[i++];
            } else {
                temp[k++] = s[j++];
            }
        }

        int start = i;
        int end = mid;
        if (i > mid) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[k++] = s[start++];
        }
        for (int t = 0; t <= (right - left); t++) {
            s[left+ t] = temp[t];
        }
    }
}
