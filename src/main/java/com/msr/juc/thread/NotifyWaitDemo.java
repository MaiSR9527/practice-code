package com.msr.juc.thread;

/**
 * @description: 两个线程交替执行
 * @author: MaiShuRen
 * @date: 2020/2/29 23:28
 * @version: v1.0
 */

public class NotifyWaitDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

    }

}

class ShareData {
    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        ++number;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        //判断
        while (number != 1) {
            this.wait();
        }
        //干活
        --number;
        System.out.println(Thread.currentThread().getName() + " \t " + number);
        //通知
        this.notifyAll();
    }


}
