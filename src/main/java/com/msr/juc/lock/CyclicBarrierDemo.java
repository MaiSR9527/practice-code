package com.msr.juc.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/3/2 18:34
 * @version: v1.0
 */

public class CyclicBarrierDemo {

    private static final int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("集齐七颗龙珠，召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 星龙珠");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }
    }
}
