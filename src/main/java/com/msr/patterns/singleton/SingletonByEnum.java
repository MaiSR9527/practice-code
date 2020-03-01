package com.msr.patterns.singleton;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 13:05
 * @version: v1.0
 */

public class SingletonByEnum implements Serializable {
    private SingletonByEnum(){}

    enum SingletonEnum{
        /**
         * 枚举单例对象
         */
        INSTANCE;
        SingletonByEnum singleton;
        SingletonEnum(){
            singleton=new SingletonByEnum();
        }
        public SingletonByEnum getInstance(){
            return singleton;
        }
    }

    public static SingletonByEnum getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        SingletonByEnum instance = SingletonByEnum.getInstance();
        SingletonByEnum instance1 = SingletonByEnum.getInstance();
        System.out.println(instance==instance1);
        try {
            Class<?> aClass = Class.forName("com.msr.patterns.singleton.SingletonByEnum");
            Constructor<?> constructor = aClass.getDeclaredConstructor();
            SingletonByEnum instance2 = (SingletonByEnum) constructor.newInstance();
            System.out.println(instance==instance2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
