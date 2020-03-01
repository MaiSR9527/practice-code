package com.msr.algorithm;

/**
 * @description: 在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。请问，当N=11时，你可以采用多少种不同的方式爬完这个楼梯（）；当N=9时呢？
 * @author: MaiShuRen
 * @date: 2020/2/18 13:35
 * @version: v1.0
 */

public class ClimbStairs {

    public static void main(String[] args) {
        
        ClimbStairs climbStairs = new ClimbStairs();
        int climb = climbStairs.climb(11);
        System.out.println(climb);
    }

    public int climb(int n) {
        int[] arr = new int[n + 1];
        if (n == 0) {
            return 1;
        }
        arr[0] = 1;
        arr[1] = 1;
        if (n == 1) {
            return 1;
        } else {
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }

    }
}
