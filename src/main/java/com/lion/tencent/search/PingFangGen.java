package com.lion.tencent.search;

/**
 * 求一个数x的平方根y
 * 求解范围 min < y < max
 * 如果 0 < x < 1   x < y < 1
 * 如果x = 1 y = 1
 * 如果 x > 1    1 < y < x
 */
public class PingFangGen {
    public static void main(String[] args) {
        System.out.println(sqrt(6));
    }

    public static double sqrt(double x) {
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double up = x;
        if (x < 1 && x > 0) {
            low = x;
            up = 1;
        }

        while (up - low > 0.000001) {
            double mid = low + (up - low) /2;
            if ((mid+0.000001)*(mid+0.000001) > x && (mid-0.000001)*(mid-0.000001) < x) {
                return mid;
            } else if (mid*mid > x) {
                up = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }
}
