package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:17
 * @version: v1.0
 */

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}
