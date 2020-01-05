package com.lion.tencent.search;

public class SimpleBinarySearch {

    public static void main(String[] args) {

    }

    public static void binary(int[] a, int key) {
        if (a == null || a.length == 1) {
            return;
        }
        int left = 0;
        int right = a.length-1;
        //循环退出条件是left<=right
        while (left <= right) {
            int mid = (right + left) /2; //可以优化为 left + (right-left) >> 1
            if (key == a[mid]) {
                System.out.println(key);
                break;
            } else if (key < a[mid]) {
                right = mid - 1;
            } else if (key > a[mid]) {
                left = mid + 1;
            }
        }
    }

    public static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }
}
