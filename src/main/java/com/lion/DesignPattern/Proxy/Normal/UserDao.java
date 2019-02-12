package com.lion.DesignPattern.Proxy.Normal;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("-----已经保存数据！！！------");
    }

}