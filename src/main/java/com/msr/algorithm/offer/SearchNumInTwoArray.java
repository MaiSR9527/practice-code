package com.msr.algorithm.offer;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/20 22:27
 * @version: v1.0
 */

public class SearchNumInTwoArray {

    public static void main(String[] args) {
        SearchNumInTwoArray searchNumInTwoArray = new SearchNumInTwoArray();
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean flag = searchNumInTwoArray.searchArray(arr, 7);
        System.out.println(flag);
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9]，
     * [2,4,9,12]，
     * [4,7,10,13]，
     * [6,8,11,15]
     * ]
     */
    public boolean searchArray(int[][] array, int target) {
        // 校验空
        if (array.length == 0) {
            return false;
        }
        // 拿到第一行最后一列的坐标 [ 0, array[0].length-1 ]
        int i = 0, j = array[0].length - 1;
        // 因为竖排纵向递增， 所以当前值如果大于target， 则这列都不用比较 ， 列前移
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) {
                System.out.println("target:" + target + "   arr:" + array[i][j]);
                return true;
            }
            if (array[i][j] > target) {
                System.out.println("target:" + target + "   arr:" + array[i][j]);
                j--;
            } else {
                i++;
                j = array[i].length - 1;
            }
        }
        return false;
    }
}
