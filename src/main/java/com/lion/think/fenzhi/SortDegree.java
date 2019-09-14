package com.lion.think.fenzhi;

/**
 * 求出一个数组中的有序度或无序度
 *
 * 例如数组：1，2，5，3
 * 有序度 (1,2) (1,5) (1,3) (2,5) (2,3)
 * 无序度 (5,3)
 * 总和 5    n*(n-1)/2  4*3/2
 */
public class SortDegree {
    private static int num = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,3};
        doo(arr, 0, arr.length -1);
        System.out.println(num);
    }

    public static void doo(int[] arr, int left, int right) {
        if (left >= right) return;
        int p = (left+right)/2;
        doo(arr, left, p);
        doo(arr, p+1, right);
        merge(arr, left, p, right);
    }

    public static void merge(int[] arr, int left,int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[right-left+1];
        while (i <= left && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                num += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        /**
         *      789| 1235
         *
         */
        while (i <= left) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i <= right-left; i++) {
            arr[left+i] = temp[i];
        }
    }
}
