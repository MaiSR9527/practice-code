package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description: 直接插入
 * @author: MaiShuRen
 * @date: 2019/12/9 15:37
 * @version: v1.0
 */

public class Insert {

    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 5, 6, 10};
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            int index = i;
            int temp = a[i];
            while (index > 0 && a[index-1]>temp) {
                a[index] = a[index-1];
                index--;
            }
            a[index]=temp;
        }
        Arrays.stream(a).forEach(System.out::println);
        long end = System.currentTimeMillis();
        long l = end - start;
        System.out.println("time:"+l+"ms");
    }
}
