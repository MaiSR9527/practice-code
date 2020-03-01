package com.msr.datastructure;

/**
 * @description: 稀疏数组
 * @author: MaiShuRen
 * @date: 2020/2/24 15:32
 * @version: v1.0
 */

public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组：11*11
        int[][] chessArr1 = new int[11][11];
        //0:没有棋子 1：黑色  2：白色
        chessArr1[1][4] = 1;
        chessArr1[4][6] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf(data + "\t");
            }
            System.out.println();
        }

        System.out.println("====================================================================");
        //将二维数组转稀疏数组
        //1.先遍历得出数据个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //存放二维数组的行数
        sparseArr[0][0] = chessArr1.length;
        //存放二维数组的列数
        sparseArr[0][1] = chessArr1[0].length;
        //存放二维数组的数据个数
        sparseArr[0][2] = sum;
    }
}
