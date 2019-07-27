package com.lion.sort.other;

/**
 * 全排列
 */
public class AllList {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        printAllSolution(a, 4, 4);
    }

    /**
     * 每次固定最后1位 则 还剩n - 1 位需要全排列
     * 最终 还剩1位要全排列 直接打印即可。
     * @param a
     * @param n
     * @param k
     */
    public static void  printAllSolution(int[] a, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + "");
            }
            System.out.println();
        }
        for (int i = 0; i < k; ++i) {
            int tmp = a[i];
            a[i] = a[k-1];
            a[k-1] = tmp;
            printAllSolution(a, n, k-1);
            //位置还原，否则可能会有重复情况
            tmp = a[i];
            a[i] = a[k-1];
            a[k-1] = tmp;
        }


    }
}
