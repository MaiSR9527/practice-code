package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:18
 * @version: v1.0
 */

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("长方形");
    }
}
