package com.lion.sort;
//计数排序
public class CountingSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,5,4,2,3};
        countingSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        int[] c = new int[max + 1];
        for(int i=0;i<=max;++i){
            c[i] = 0;
        }
        for (int i = 0; i<n; i++) {
            c[a[i]] ++;
        }
        //依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i-1] + c[i];
        }
        //临时shuzu
        int[] r = new int[n];
        for (int i = n-1; i>=0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < n;i++) {
            a[i] = r[i];
        }
    }
}
