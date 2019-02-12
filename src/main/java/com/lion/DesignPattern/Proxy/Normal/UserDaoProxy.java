package com.lion.DesignPattern.Proxy.Normal;

/**
 * 静态代理类
 */
public class UserDaoProxy implements IUserDao {

    // 接收保存目标对象【真正做事的还是UserDao】，因此需要维护userDao的引用
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");

        target.save();          // 执行目标对象的方法

        System.out.println("提交事务...");
    }
}