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

    /**
     * 查找第一个值为key的下标
     * @param s
     * @param key
     * @return
     */
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
                // 如果找到了 判断mid是否为0,如果是0则为第一个 判断左边是否还要值为key的 如果有 high=mid-1
                if (mid == 0 || (s[mid-1]  != key)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值为key的下标
     * @param s
     * @param key
     * @return
     */
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
                // 如果mid最后一个元素 或 mid +1元素不是key
                if (mid == (s.length-1) || s[mid+1] != key) {
                    return mid;
                } else {
                    //否则 + 1
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值得下标
     * @param s
     * @param key
     * @return
     */
    public static int binary3(int[] s, int key) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key > s[mid]) {
                low = mid + 1;
            } else if (key <= s[mid]){
                //如果mid > key了，那么 看mid左边还有没有大于 key的
                if (s[mid - 1] < key || mid == 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值下标
     * @param s
     * @param key
     * @return
     */
    public static int binary4(int[] s, int key) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(key < s[mid]) {
                high = mid - 1;
            } else if (key >= s[mid]) {
                // 如果mid < key  那么判断mid右边是否还有小于key的
                if (mid == s.length - 1 || s[mid + 1] > key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 循环数组判断  7 8 9 1 2 3
     * @param s
     * @param key
     * @return
     */
    public static int binary5(int[] s, int key) {
        if (s.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (s[mid] == key) {
                return mid;
            }
            //转折点在右边(大-> 超大  小 -> 大) mid 为9 left 7 right 3
            if (s[left] <= s[mid]) {
                if (key >= s[left] && key < s[mid]) { // 如果key大于left 小于mid 说明在中间
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (key > s[mid] && key <= s[right]) { // 如果key大于mid 小于right left = mid+1
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
