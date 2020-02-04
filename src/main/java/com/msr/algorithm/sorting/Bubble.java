package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: MaiShuRen
 * @date: 2019/12/9 15:20
 * @version: v1.0
 */

public class Bubble {

    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 5, 6, 10};
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        Arrays.stream(a).forEach(System.out::println);
        long end = System.currentTimeMillis();
        long l = end - start;
        System.out.println("time:"+l+"ms");
    }
}
