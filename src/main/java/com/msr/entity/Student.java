package com.msr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/13 15:58
 * @version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private int num;
    private String name;
    private int age;
    private Person person;
}
