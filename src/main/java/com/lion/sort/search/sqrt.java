package com.lion.sort.search;

/**
 * 求一个数的平方根
 */
public class sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }

    public static double sqrt(double n) {
        double low = 0;
        double high = n;
        double mid = mid = (high-low) /2;;
        while (0.000001<(high-low)) {
            if (mid *mid > n) {
                high = mid;
            } else if (mid * mid < n) {
                low = mid;
            } else if (Math.abs(mid * mid - n) < 0.000001){
                return low;
            }
            mid=low+(high-low)/2;
        }
        return mid;
    }
}
