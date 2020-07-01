package com.zyuc.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/6 17:38
 * @Created by ChenHao
 */
public class HelloImpl implements IHello {

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        IHello iHello = new HelloImpl();
        ProxyHandler proxyHandler = new ProxyHandler(iHello);
        IHello proxyHello = (IHello) Proxy.newProxyInstance(iHello.getClass().getClassLoader(), iHello.getClass().getInterfaces(), proxyHandler);
        proxyHello.sayHello();

//        HelloImpl hello = new HelloImpl();
//        ProxyHandler proxyHandler = new ProxyHandler(hello);
//        HelloImpl proxyHello = (HelloImpl) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), proxyHandler);
//        proxyHello.sayHello();
    }
}
