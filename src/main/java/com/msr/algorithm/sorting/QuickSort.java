package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/18 16:40
 * @version: v1.0
 */

public class QuickSort {

    private static int[] quick(int[] a, int low, int high) {
        long ss = System.currentTimeMillis();
        int start = low;
        int end = high;
        int baseKey = a[start];
        while (start < end) {
            while (start < end && baseKey <= a[end]) {
                end--;
            }
            if (baseKey > a[end]) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while (start < end && baseKey >= a[start]) {
                start++;
            }
            if (baseKey < a[start]) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if (start > low) {
            quick(a, low, start);
        }
        if (end < high) {
            quick(a, end + 1, high);
        }
        System.out.println("end :"+(System.currentTimeMillis() - ss));
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 9, 3, 7, 0, 5};
        int[] quickArr = quick(a, 0, a.length - 1);

        Arrays.stream(a).forEach(System.out::println);
    }
}
