package com.msr.patterns.proxy;

/**
 * @description: 代理模式：静态代理
 * @author: MaiShuRen
 * @date: 2019/12/7 21:33
 * @version: v1.0
 */

public class StaticAgentProxy {

    private Test test;

    public StaticAgentProxy(Test test){
        this.test=test;
    }

    public void hello(){
        System.out.println("==============");
        test.hello();
        System.out.println("==============");
    }

    public static void main(String[] args) {
        StaticAgentProxy staticAgentProxy = new StaticAgentProxy(new TestImpl());
        staticAgentProxy.hello();
    }
}
