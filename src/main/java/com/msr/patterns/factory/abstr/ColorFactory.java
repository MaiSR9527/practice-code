package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:23
 * @version: v1.0
 */

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        } else if ("RED".equalsIgnoreCase(color)) {
            return new Red();
        } else if ("GREEN".equalsIgnoreCase(color)) {
            return new Green();
        } else if ("BLUE".equalsIgnoreCase(color)) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
