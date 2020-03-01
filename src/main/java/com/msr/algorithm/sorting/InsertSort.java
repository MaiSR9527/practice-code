package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description: 直接插入
 * @author: MaiShuRen
 * @date: 2019/12/9 15:37
 * @version: v1.0
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 5, 6, 10};
        for (int i = 0; i < a.length; i++) {
            int index = i;
            int insertNum = a[i];
            while (index > 0 && a[index - 1] > insertNum) {
                a[index] = a[index - 1];
                index--;
            }
            a[index] = insertNum;
        }
        Arrays.stream(a).forEach(System.out::println);
    }
}
