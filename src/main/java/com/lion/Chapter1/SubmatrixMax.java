package com.lion.Chapter1;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * 1  0  1  1
 * 1  1  1  1
 * 1  1  1  0
 *
 * =》
 *
 * 1.  1  0  1  1
 * 2.  2  1  1  1
 * 3.  3  2  3  0       2 * 3 = 6
 *
 */
public class SubmatrixMax {
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        System.out.println(maxRecSize(map));
    }
    public static int maxRecSize(int[][] map) {
        if (map == null) {
            return 0;
        }
        int[] height = new int[map[0].length];
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += map[i][j];
                }
            }
            int now = maxRecFromBottom(height);
            max = max > now ? max : now;
        }
        return max;
    }

    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while (i < height.length) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                max = max > curArea ? max : curArea;
            }
            stack.push(i);
            i++;
        }
        /**
         * 如果最后stack还有2个
         * a
         * b
         * 那么必定是 a < b
         * b周围的必定是最小的，如果不是最小的 b肯定不是栈底
         * a到元素最后 没有比 a大的了 height.length - b位置 -1
         *
         */
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k -1) * height[j];
            max = Math.max(max, curArea);
        }
        return max;
    }
}
