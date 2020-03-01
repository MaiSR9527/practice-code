package com.msr.patterns.factory.abstr;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 11:22
 * @version: v1.0
 */

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {

        if (shape==null){
            return null;
        }else if ("CIRCLE".equalsIgnoreCase(shape)){
            return new Circle();
        }else if ("RECTANGLE".equalsIgnoreCase(shape)){
            return new Rectangle();
        }else if ("SQUARE".equalsIgnoreCase(shape)){
            return new Square();
        }
        return null;
    }
}
