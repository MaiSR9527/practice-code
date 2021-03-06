package com.msr.algorithm.sorting;

import java.util.Arrays;

/**
 * @description: 归并排序
 * @author: MaiShuRen
 * @date: 2020/2/18 16:40
 * @version: v1.0
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 9, 3, 7, 0, 5};

        a = mergeSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(System.out::print);
    }

    private static int[] mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 拆分
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
        return a;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int index = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[index++] = a[i++];
            } else {
                temp[index++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= high) {
            temp[index++] = a[j++];
        }
        // 覆盖原数组
        if (temp.length >= 0){
            System.arraycopy(temp, 0, a, low, temp.length);
        }
    }
}
