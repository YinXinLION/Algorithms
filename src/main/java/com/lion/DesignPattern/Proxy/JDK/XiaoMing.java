package com.lion.DesignPattern.Proxy.JDK;

/**
 * 目标对象
 */
public class XiaoMing  implements Person {
    @Override
    public void sing(String name) {

        System.out.println("小明唱" + name);
    }

    @Override
    public void dance(String name) {

        System.out.println("小明跳" + name);

    }
}
