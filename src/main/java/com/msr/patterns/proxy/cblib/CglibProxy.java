package com.msr.patterns.proxy.cblib;

import com.msr.patterns.proxy.TestImpl;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/7 22:57
 * @version: v1.0
 */

public class CglibProxy {

    public static void main(String[] args) {
        TestImpl test = new TestImpl();
        TestImpl proxyInstance = (TestImpl) new ProxyFactory(test).getProxyInstance();

        proxyInstance.cglib();
    }
}
