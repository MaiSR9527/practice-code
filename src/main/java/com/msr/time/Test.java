package com.msr.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/18 10:58
 * @version: v1.0
 */

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        char[] chars = n.toCharArray();
        

    }

    public void findOne(int[] arr) {
        for (int i : arr) {
            String s = i + "";
            if (s.contains("1")) {
                System.out.println(s);
            }
        }
    }
    public void findOneV2(int[] arr) {

        for (int i : arr) {
            if (i%10==1){
                System.out.println(i);
            }
            String s = i + "";
            if (s.contains("1")) {
                System.out.println(s);
            }
        }
    }
}
