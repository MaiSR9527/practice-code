package com.msr.datastructure.loveDataStructure1;

/**
 * @description: 斐波那契数列
 * @author: MaiShuRen
 * @date: 2020/3/23 09:58
 * @version: v1.0
 */

public class Fibonacci {

    /**
     * 递归调用，容易导致栈溢出
     *
     * @param n 位数
     * @return 结果
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 循环加
     * 比递归好
     *
     * @param n 位数
     * @return 结果
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second; 
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        TimeTool.testTime("fib", () -> System.out.println(fib(40)));

        TimeTool.testTime("fib2", () -> System.out.println(fib2(40)));
    }
}
