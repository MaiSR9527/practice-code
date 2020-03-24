package com.msr.juc.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒。
 * @author: MaiShuRen
 * @date: 2020/3/2 17:22
 * @version: v1.0
 */

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println("hello"+ finalI);
                countDownLatch.countDown();
            },"thread"+i).start();
        }
        try {
            countDownLatch.await();
            System.out.println("finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
