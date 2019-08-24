package com.lion.stringCompare;

public class BM {
    /**
     *
     * @param b
     * @param suffix 它的下标代表前缀长度  值存储的是前缀子串匹配的起始位置
     * @param prefix 下标代表前缀长度 值存储的是 记录后缀子串是否能匹配前缀子串
     * @return
     */
    public static String find(char[] b, int[] suffix, boolean[] prefix) {
        // 为什么是b.length - 1 也就是到 倒数第二位元素为止
        // 如果到倒数第一位，那我还求神马? so,length - 1
        for (int i = 0; i < b.length -1; i++) {
            int j = i;
            int k = 0; // 公共后缀长度
            while (j >= 0 && b[j] == b[b.length - k - 1]) {
                suffix[k] = j;//j 表示后缀子串在b[0,i]的起始下标
                --j;
                ++k;
            }
            if (j == -1) { //如果j-1了那么长度为k的子串匹配成功
                prefix[k] = true;
            }
        }
        int max = -1;
        for (int i = 0; i <  prefix.length; i++) {
            if (prefix[i] == true) {
                max =  i;
            }
        }
        for (int i = 0 ; i < suffix.length; i++) {
            System.out.println(i + ":" +suffix[i]);
        }
        if (max == -1) {
            return "";
        } else {
            return new String(b, 0, max);
        }
    }

    public static void main(String[] args) {
        char[] b = new char[]{'a','b','c','a','b','c'};
        int[] suffix = new int[b.length];
        boolean[] preifx = new boolean[b.length];
        String s = find(b, suffix, preifx);
        System.out.println(s);
    }
}
