package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description: 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
 * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
 * 不断进行这样的操作，直到将整个数组排序。
 * @author: MaiShuRen
 * @date: 2020/2/18 14:38
 * @version: v1.0
 */

public class SelectiveSort {

    public static void main(String[] args) {
        //慢，就算是已经排好序了，还是会再区确认。
        int[] a = new int[]{9, 21, 1, 3, 8, 11, 10, 5};
        int index;
        for (int i = 0; i < a.length; i++) {
            index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[index] > a[j]) {
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        Arrays.stream(a).forEach(System.out::println);
    }
}
