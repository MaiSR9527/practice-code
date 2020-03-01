package com.msr.patterns.factory.method;

import com.msr.patterns.factory.Milk;
import com.msr.patterns.factory.simple.Yili;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:05
 * @version: v1.0
 */

public class YiliMilkFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
