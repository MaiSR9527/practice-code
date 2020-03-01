package com.msr.patterns.singleton;

import java.io.Serializable;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/28 23:34
 * @version: v1.0
 */

public class SingletonHolder implements Serializable {

    // 外部类的私有构造方法
    private SingletonHolder() {
    }

    // 外部类静态方法，通过静态内部类的静态成员变量获取
    public static SingletonHolder getInstance() {
        return Holder.instance;
    }

    private Object readResolve() {
        return Holder.instance;
    }

    // 静态内部类内部加载的时候创建外部类，只加载一次，所以只创建一个
    private static final class Holder {
        private static final SingletonHolder instance = new SingletonHolder();
    }


}
