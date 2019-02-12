package com.lion.DesignPattern.Proxy.CGLIB;

import com.lion.DesignPattern.Proxy.Normal.UserDao;

/**
 * 测试
 */
public class App {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        UserDao factory = (UserDao) new ProxyFactory(userDao).getProxyInstance();

        factory.save();
    }
}
