package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:20
 * @version: v1.0
 */

public abstract class AbstractFactory {

    /**
     *
     * @param color
     * @return
     */
    public abstract Color getColor(String color);

    /**
     *
     * @param shape
     * @return
     */
    public abstract Shape getShape(String shape);
}
