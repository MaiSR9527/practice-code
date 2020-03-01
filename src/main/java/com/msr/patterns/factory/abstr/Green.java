package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:20
 * @version: v1.0
 */

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("绿色的");
    }
}
