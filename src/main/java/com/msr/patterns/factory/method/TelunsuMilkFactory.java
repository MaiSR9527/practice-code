package com.msr.patterns.factory.method;

import com.msr.patterns.factory.Milk;
import com.msr.patterns.factory.simple.Telunsu;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:04
 * @version: v1.0
 */

public class TelunsuMilkFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
