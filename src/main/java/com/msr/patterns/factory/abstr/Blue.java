package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:19
 * @version: v1.0
 */

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("蓝色的");
    }
}
