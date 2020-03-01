package com.msr.patterns.factory.simple;

import com.msr.patterns.factory.Milk;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 10:51
 * @version: v1.0
 */

public class Yili implements Milk {
    @Override
    public void createMilk() {
        System.out.println("生产伊利牛奶....");
    }
}
