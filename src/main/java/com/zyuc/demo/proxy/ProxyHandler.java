package com.zyuc.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/6 17:26
 * @Created by ChenHao
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前执行..." + method.getName());
        method.invoke(object, args);
        System.out.println("代理后执行..." + method.getName());
        return null;
    }
}
