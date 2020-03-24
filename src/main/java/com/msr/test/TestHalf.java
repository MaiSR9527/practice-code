package com.msr.test;

import com.msr.patterns.proxy.Test;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/8 13:51
 * @version: v1.0
 */
@Slf4j
public class TestHalf {


    public static void main(String[] args) {
        TestHalf testHalf = new TestHalf();
        testHalf.print(6);
    }

    public static long getValue(int n, int m) {
        return (factorial(n) / (factorial(m) * factorial(n - m)));
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }

    public void print(int size) {
        for (int i = 1; i <= size; i++) {
            int k = 17;
            if (i == 5) {
                k -= 0;
            } else if (i == 6) {
                k -= 1;
            }
            for (; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j < i + 1; j++) {
                System.out.print(" " + getValue(i - 1, j - 1));
            }
            System.out.println();
        }
    }
        /*Date date = new Date();

        SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-01 00:00:00");

        Calendar instance1 = Calendar.getInstance();
        instance1.setTime(date);
        instance1.add(Calendar.MONTH,-6);

        Date startTime = instance1.getTime();
        String formatStart = startFormat.format(startTime);

        Date parse = startFormat.parse(formatStart);
        log.info("StartDate {}",parse);


        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        Date endTime = instance2.getTime();

        String formatEnd = startFormat.format(endTime);
        Date parse1 = startFormat.parse(formatEnd);
        log.info("EndDate {}",parse1);*/



}
