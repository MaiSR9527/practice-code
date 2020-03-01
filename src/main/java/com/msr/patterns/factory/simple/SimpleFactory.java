package com.msr.patterns.factory.simple;

import com.msr.patterns.factory.Milk;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/8 10:43
 * @version: v1.0
 */

public class SimpleFactory {

    public Milk getMilk(String name){
        if ("特仑苏".equals(name)){
            return new Telunsu();
        }else if ("伊利".equals(name)){
            return new Yili();
        }else {
            System.out.println("不存在的奶牛品牌");
            return null;
        }
    }
}
