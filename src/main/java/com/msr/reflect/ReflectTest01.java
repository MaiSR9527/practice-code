package com.msr.reflect;

import com.msr.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: maishuren
 * @Date: 2019/11/6 10:35
 */
public class ReflectTest01 {

    public static void main(String[] args) {
        //创建对象
//        newInstance();

        //反射私有构造
        newPrivate();

        //反射获取方法并执行和获取私有属性
        getFieldAndMethod();
    }

    public static void newInstance() {
        try {
            Class<?> aClass = Class.forName("com.msr.entity.Person");
            Object instance = aClass.newInstance();
            Person person = (Person) instance;
            person.setId("1");
            person.setName("msr");
            System.out.println("reflect --- " + person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newPrivate() {
        try {
            Class<?> aClass = Class.forName("com.msr.entity.Person");
            Constructor<?> constructor1 = aClass.getDeclaredConstructor(String.class, String.class);
            Constructor<?> constructor2 = aClass.getDeclaredConstructor();

            constructor1.setAccessible(true);
            constructor2.setAccessible(true);

            Object instance1 = constructor1.newInstance("1", "allArgs");
            Object instance2 = constructor2.newInstance();

            Person person1 = (Person) instance1;
            Person person2 = (Person) instance2;

            person2.setId("2");
            person2.setName("norArgs");

            System.out.println(person1.toString());
            System.out.println(person2.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getFieldAndMethod(){
        try {
            Class<?> personClass = Class.forName("com.msr.entity.Person");

            Constructor<?> constructor = personClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object instance = constructor.newInstance();

            Field person = personClass.getDeclaredField("person");
            person.setAccessible(true);

            String str = (String) person.get(instance);
            System.out.println(str);

            Method hello = personClass.getDeclaredMethod("hello1", String.class);
            hello.setAccessible(true);
            Method hello1 = personClass.getMethod("hello", String.class);
            hello1.setAccessible(true);
            hello.invoke(instance,"私有方法");
            hello1.invoke(instance,"共有方法");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
