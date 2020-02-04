package com.msr.patterns.proxy;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/7 21:35
 * @version: v1.0
 */

public class TestImpl implements Test {


    @Override
    public void hi() {
        System.out.println("hi!jdk proxy");
    }
    @Override
    public void hello() {
        System.out.println("hello static proxy");
    }

    @Override
    public void cglib() {
        System.out.println("hello cglib proxy");
    }

}
