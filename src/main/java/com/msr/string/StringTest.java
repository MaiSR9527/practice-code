package com.msr.string;

import java.util.Objects;

/**
 * @description: 字符串相关
 * @author: MaiShuRen
 * @date: 2019/12/26 09:56
 * @version: v1.0
 */

public class StringTest {

    public static void main(String[] args) {
        String s = new String("hello");
        String s1 = s.intern();
        System.out.println(s1==s);
    }
}
