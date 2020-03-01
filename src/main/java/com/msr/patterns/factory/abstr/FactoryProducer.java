package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:27
 * @version: v1.0
 */

public class FactoryProducer {
    public static AbstractFactory getShapeFactory() {
        return new ShapeFactory();
    }

    public static AbstractFactory getColorFactory() {
        return new ColorFactory();
    }
}
