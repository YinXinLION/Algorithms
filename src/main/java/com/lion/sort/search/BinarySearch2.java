package com.lion.sort.search;

/**
 * 二分查找法 变种： 查找第一个值为key的下标
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] s = new int[]{1,3,5,6,7,7,7,9};
        System.out.println(binary(s, 6));
    }
    public static int binary(int[] s, int key) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (s[mid] < key) {
                low = mid + 1;
            } else if (s[mid] > key) {
                high = mid - 1;
            } else {
                if (mid == 0 || (s[mid-1]  != key)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
