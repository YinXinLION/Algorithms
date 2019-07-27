package com.lion.tree;

/**
 * 堆的插入删除 时间复杂度 logn
 */
public class Heap {
    private int[] a; //数组，从下标1开始存储数据
    private int n;//堆可以存储的最大数据个数
    private int count; //堆中已经存储的个数

    public Heap(int capacity) {
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    //大根堆
    public void insert(int data) {
        if (count > n) { //堆满了
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {
           int temp = a[i];
           a[i] = a[i/2];
           a[i/2] = temp;
           i = i/2;
        }
    }

    //大根堆删除
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    //从位置i开始查看是否应该往下移动
    private static void heapify(int[] a, int n, int i) { //自上往下堆化
        while (true) {
            int maxPos = i;
            if (2*i <= n && a[i] < a[2*i]) maxPos = i*2;
            if (2*i + 1 <= n && a[maxPos] < a[2*i+1]) maxPos = 2*i+1;
            if (maxPos == i) break;
            //交换
            int temp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = temp;
            i = maxPos;
        }
    }


    /**
     * 堆排序
     * 不是稳定排序，存在将堆中最后一个节点跟堆顶交换，改变相同值得原有顺序
     * 建堆On 排序 nlogn
     * 快速排序可以利用局部顺序访问，CPU缓存 局部性原理
     *
     */

    /**
     * 建堆的时间复杂度为 O（n）
     * @param a
     * @param n
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(a, n, i);
        }

    }

    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            int temp = a[k];
            a[k] = a[1];
            a[1] = temp;
            k--;
            heapify(a, k, 1);
        }
        // k == 1的时候已排好序
    }
}
