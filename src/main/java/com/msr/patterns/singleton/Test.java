package com.msr.patterns.singleton;

import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/28 23:36
 * @version: v1.0
 */

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("com.msr.patterns.singleton.SingletonHolder");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonHolder holder = SingletonHolder.getInstance();
        SingletonHolder instance = (SingletonHolder) constructor.newInstance();
        System.out.println(holder);
        System.out.println(instance);
        System.out.println(holder == instance);

        byte[] serialize = SerializationUtils.serialize(SingletonHolder.getInstance());
        SingletonHolder deserialize = SerializationUtils.deserialize(serialize);
        System.out.println(deserialize == instance);


        System.out.println("===================");
        SingletonByEnum o1 = SingletonByEnum.getInstance();
        try {
            Class<?> es = Class.forName("com.msr.patterns.singleton.SingletonByEnum");
            Constructor<?> ec = es.getDeclaredConstructor();
            ec.setAccessible(true);
            SingletonByEnum o2 = (SingletonByEnum) ec.newInstance();
            System.out.println(o1 == o2);
            System.out.println(o1 + "  " + o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======================");
        byte[] ser = SerializationUtils.serialize(o1);
        SingletonByEnum o3 = SerializationUtils.deserialize(ser);
        System.out.println(o1 == o3);
    }
}
