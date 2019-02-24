package com.lion.Chapter1;

/**
 * 前几天 旁边问我 Long当参数传过去 改变后，能否在原方法用改后的值
 * =-= 当时有些懵逼 测了下--不行。
 * Long l 在 main方法开辟一个 空间 地址指向12222L
 * to方法此时开辟了一个空间 这个空间指向堆里头的一个对象
 * to 空间内容的变化，不影响main中l空间的内容。
 * 。。。
 */
public class LongTest {
    public static void main(String[] args) {
        Long l = 12222L;
        to(l);
        System.out.println(l);
    }

    public static void to(Long l) {
        l = 11113L;
    }
}
