package com.msr.patterns.singleton;

/**
 * @Description: 单例模式
 * @Author: MaiShuRen
 * @Date: 2019/11/20 23:26
 */

public class Singleton {

    /**
     * 饿汉式
     */
    private static Singleton singleton = new Singleton();
    private volatile static Singleton singleton1;

    private Singleton() {
    }

    /**
     * 饿汉式
     * @return
     */
    public static Singleton getInstance() {
        return singleton;
    }

    /**
     * 双重判空、懒汉式: volatile防止指令重排
     */
    public static Singleton getInstance1() {
        if (singleton1 == null) {
            synchronized (Singleton.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton();
                }
            }
        }
        return singleton1;
    }
}
