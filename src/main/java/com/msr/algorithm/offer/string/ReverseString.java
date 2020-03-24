package com.msr.algorithm.offer.string;

/**
 * @description: 逆转字符串
 * @author: MaiShuRen
 * @date: 2020/3/12 22:21
 * @version: v1.0
 */

public class ReverseString {

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {
        String reverse = ReverseString.reverse("hello");
        System.out.println(reverse);
    }
}
