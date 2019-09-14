package com.lion.think.huishuo;

/**
 * 0-1 背包 使用回溯思想求解重量最大
 *
 * 如果背包问题 每个物品价值不同，不超过背包重量情况下，让背包价值最大 如何做？
 */
public class ZeroOne {

    public static int maxW = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] array = new int[]{1,3,5};
        int w = 7;
        f(0, 0, array, array.length, w);
        System.out.println(maxW);
    }

    /**
     *
     * @param weight 当前背包装物品的重量和
     * @param index 访问到第几个物品
     * @param array 物品数组
     * @param length 物品个数
     * @param w 背包容量限制
     */
    public static void f(int weight, int index, int[] array, int length, int w) {
        if (index == length || weight == w) {
            if (weight > maxW) {
                maxW = weight;
            }
            return;
        }
        // 不加当前物品
        f(weight, index+1, array, length, w);
        if (weight + array[index] <= w) {
            f(weight+array[index], index+1, array, length, w);
        }
    }
}
