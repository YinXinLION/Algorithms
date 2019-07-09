package com.lion.sort.search;

/**
 * 二分查找法 变种1： 查找第一个值为key的下标
 *          变种2： 查找最后一个值为key的下标
 *          变种3:  查找第一个大于等于给定值得下标
 *          变种4： 查找最后一个小于等于给定值下标
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] s = new int[]{1,3,5,6,7,7,7,9};
        System.out.println(binary1(s, 7));
        System.out.println(binary2(s, 7));
    }
    public static int binary1(int[] s, int key) {
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

    public static int binary2(int[] s, int key) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (s[mid] < key) {
                low = mid + 1;
            } else if (s[mid] > key) {
                high = mid - 1;
            } else {
                if (mid == (s.length-1) || s[mid+1] != key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int binary3(int[] s, int key) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key > s[mid]) {
                low = mid + 1;
            } else if (key <= s[mid]){
                if (s[mid - 1] < key || mid == 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binary4(int[] s, int key) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(key < s[mid]) {
                high = mid - 1;
            } else if (key >= s[mid]) {
                if (mid == s.length - 1 || s[mid + 1] > key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
