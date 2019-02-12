package com.lion.DesignPattern.Proxy.CGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//需要实现MethodInterceptor接口
public class ProxyFactory implements MethodInterceptor {
    // 维护目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    // 给目标对象创建代理对象
    public Object getProxyInstance(){
        //1. 工具类
        Enhancer en = new Enhancer();
        //2. 设置父类
        en.setSuperclass(target.getClass());
        //3. 设置回调函数
        en.setCallback(this);
        //4. 创建子类(代理对象)
        return en.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {

        System.out.println("开始事务.....");

        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        System.out.println("提交事务.....");

        return returnValue;
    }
}

