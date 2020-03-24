package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description: 希尔排序
 * @author: MaiShuRen
 * @date: 2020/3/1 18:32
 * @version: v1.0
 */

public class ShellSort {

    public static void main(String[] args) {
        int[] data = new int[]{1, 9, 5, 6, 10};
        int j;
        int temp;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
        Arrays.stream(data).forEach(System.out::println);
    }
}
