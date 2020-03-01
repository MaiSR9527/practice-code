package com.msr.patterns.factory;

import com.msr.patterns.factory.Milk;
import com.msr.patterns.factory.abstr.FactoryProducer;
import com.msr.patterns.factory.method.Factory;
import com.msr.patterns.factory.method.TelunsuMilkFactory;
import com.msr.patterns.factory.method.YiliMilkFactory;
import com.msr.patterns.factory.simple.SimpleFactory;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 10:47
 * @version: v1.0
 */

public class TestDemo {

    public static void main(String[] args) {
        //简单工厂：小作坊的生产模式 用户不在关心生产的过程 而只关心结果
        SimpleFactory simpleFactory = new SimpleFactory();
        //隐藏创建过程
        Milk milk = simpleFactory.getMilk("伊利");
        milk.createMilk();

        System.out.println("=============================");

        //工厂方法 不知道是谁好  配置？
        Factory factory = new YiliMilkFactory();
        Factory factory1 = new TelunsuMilkFactory();

        factory.getMilk().createMilk();
        factory1.getMilk().createMilk();

        System.out.println("==============================");

        FactoryProducer.getColorFactory().getColor("RED").fill();
        FactoryProducer.getShapeFactory().getShape("SQUARE").draw();
    }
}
