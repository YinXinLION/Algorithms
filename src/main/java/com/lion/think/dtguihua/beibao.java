package com.lion.think.dtguihua;

public class beibao {
    /**
     * 0-1背包 求最大重量
     * @param weight 物品重量
     * @param n 物品个数
     * @param w 可承受重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        for (int i = 1; i < n; i++) {
            // 不把第i个物品放入背包
            for (int j = 0; j <= w; j++) {
                if (states[i-1][j] == true) { //如果有状态，那么要进行叠加
                    states[i][j] = true;
                }
            }
            // 把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i-1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >=0; i--) {
            if (states[n-1][i] == true) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 0-1背包求最大重量
     * 将2维转为1维数组
     * @return
     */
    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[0] = true;
        states[items[0]] = true;
        for (int i = 1; i < n; i++) {
            // 此处注意：为什么要从大到小呢？
            //如果从小到大，第i轮循环中新设置的值会影响后面设的值
            for (int j = w - items[i]; j >=0; j++) {
                if (states[j] == true) {
                    states[j+items[i]] = true;
                }
            }
        }
        for (int i = w; i >=0; i--) {
            if (states[i] == true) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 0-1背包，求重量限制的情况下，背包装物品的最大价值
     * @param weight 每个物品的重量
     * @param value 每个物品的价值
     * @param n 物品个数
     * @param w 物品限制重量
     * @return
     */
    public int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        // 初始化
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < w+1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            //不选第i个物品
            for (int j = 0; j < w; j++) {
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }
            //选第i个物品
            for (int j = 0; j < w - weight[j]; j++) {
                int v = states[i-1][j] + value[i];
                if (v > states[i][j+weight[i]]) {
                    states[i][j+weight[i]] = v;
                }
            }
        }
        //找出最大值
        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n-1][j] > maxValue) {
                maxValue = states[n-1][j];
            }
        }
        return maxValue;
    }

}
