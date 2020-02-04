package com.msr.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @description: 实体类
 * @author: MaiShuRen
 * @date: 2019/12/5 10:52
 * @version: v1.0
 */
@Data
@NoArgsConstructor()
@AllArgsConstructor()
public class Person implements Serializable {

    private static String person = "hello";

    private String id;
    private String name;
    private Integer age;

    public void hello(String name) {
        System.out.println("hello " + name);
    }
    private void hello1(String name) {
        System.out.println("method hello1 ---- hello " + name);
    }

    public void hello(Person person) {
        System.out.println(person.toString());
    }

}
