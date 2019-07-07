package com.lion.sort.search;

/**
 * 二分查找
 * 1.依赖数组
 * 2.针对有序数据 二分查找用在插入删除不频繁的场景
 */
public class BinarySearch1 {
    public static void main(String[] args) {
        int[] a = new int[]{1,4,6,8,3,2,7,11};
        int i = bsearch(a,a.length,11);
        System.out.println(a[i]);
    }

    public static int bsearch(int[] a, int n, int key) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
//            int mid = (high + low) / 2;
//            int mid = low + (high - low) >> 1;
            int mid = low;
            if (high - low != 0) {
                mid = low + (high - low) /2;
            }
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //递归版
    public int bsearch(int[] a, int key) {
        return bsearch_digui(a, 0, a.length, key);
    }
    public static int bsearch_digui(int[] a, int low ,int high, int key) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == key) {
            return mid;
        }else if (a[mid] < key) {
            return bsearch_digui(a, mid+1, high, key);
        } else {
            return bsearch_digui(a, low, mid-1, key);
        }
    }
}
