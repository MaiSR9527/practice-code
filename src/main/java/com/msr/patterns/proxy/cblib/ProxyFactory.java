package com.msr.patterns.proxy.cblib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/7 23:03
 * @version: v1.0
 */

public class ProxyFactory implements MethodInterceptor {

    /**
     * 维护目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    /**
     * 给目标对象创建一个代理对象
     * @return 代理对象
     */
    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //创建回调函数
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        Object invoke1 = methodProxy.invokeSuper(target, objects);
        System.out.println("==========================");
        Object invoke2 = methodProxy.invoke(target, objects);
        System.out.println("========Cglib代理=========");
        Object invoke = method.invoke(target, objects);
        System.out.println("==========================");
        return invoke;
    }
}
