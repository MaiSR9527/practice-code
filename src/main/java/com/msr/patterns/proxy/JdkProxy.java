package com.msr.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * @description: jdk动态代理
 * @author: MaiShuRen
 * @date: 2019/12/7 22:16
 * @version: v1.0
 */

public class JdkProxy {

    /**
     * static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
     * ClassLoader loader：指定当前目标对象使用类加载器，写法固定
     * Class<?>[] interfaces：目标对象实现的接口的类型，写法固定
     * InvocationHandler h：事件处理接口，需传入一个实现类，一般直接使用匿名内部类
     */
    public static void main(String[] args) {
        TestImpl test = new TestImpl();

        Test testInterface = (Test) Proxy.newProxyInstance(
                test.getClass().getClassLoader(),
                test.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    //proxy
                    System.out.println("=====jdk动态代理=====");
                    Object invoke = method.invoke(test, args1);
                    String name = method.getName();
                    System.out.println(name);
                    System.out.println("=====================");
                    return invoke;
                });
        testInterface.hi();
    }
}
