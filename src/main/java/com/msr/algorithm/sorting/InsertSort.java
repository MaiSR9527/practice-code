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
        // 平均 n^2 最好 n^2 最坏 n^2 空间 1
        int[] a = new int[]{1, 9, 5, 6, 10};
        for (int i = 1; i < a.length; i++) {
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
