package com.lion.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 函数式接口
 * 1.如果一个接口只有一个抽象方法，那么这个接口是一个函数式接口'
 * 2.如果某个接口声明了@FunctionalInterface注解，那么编译器会按照该定义要求接口。
 * 3.如果一个接口只有抽象方法，即使不加，也是函数式接口。
 *
 */
public class test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
