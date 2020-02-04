package com.msr.algorithm.think;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分治思想
 * @author: MaiShuRen
 * @date: 2019/12/19 09:49
 * @version: v1.0
 */

public class Divide {


    /*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    示例:
    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/

    private static int maxSubArray(int[] num) {
        //思路：分治法
        //如果把数组分成左右两段，那么加和最大的连续子序列，
        //要么出现在数组的左半部分，
        //要么出现在数组的右半部分，
        //要么出现在中间，即从左半部分和右半部分相邻的地方各取一段。
        return maxSubArray(num, 0, num.length - 1);
    }


    private static int maxSubArray(int[] nums, int l, int r) {
        return 0;
    }

    public static void main(String[] args) {

        List<Integer> integerList = diffWaysToCompute("2-1*2+2");
        System.out.println(integerList);
    }

    /**
     * 为运算设计优先级
     *
     * @param input 输入字符串
     * @return 返回所有的运算结果
     */
    private static List<Integer> diffWaysToCompute(String input) {
        /*给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
        你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
        输入: "2-1-1"
        输出: [0, 2]
        解释:
            ((2-1)-1) = 0
            (2-(1-1)) = 2
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                System.out.println(input);
                System.out.println("left:" + left + ", right:" + right);
                System.out.println("==============================");
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
