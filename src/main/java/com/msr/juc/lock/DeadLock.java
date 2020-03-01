package com.msr.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/6 14:00
 * @version: v1.0
 */

public class DeadLock {

    /**
     * jps 命令查看进程
     * @param args args
     */
    public static void main(String[] args) {
        String a = "lock1";
        String b = "lock2";
        HoldLockThread thread1 = new HoldLockThread(a, b);
        HoldLockThread thread2 = new HoldLockThread(b, a);
        new Thread(thread1).start();
        new Thread(thread2).start();
    }
}


class HoldLockThread implements Runnable {

    private final String lockA;
    private final String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (this.lockA) {
            System.out.println(Thread.currentThread().getName() + "持有lockA:" + lockA + "  尝试获取lockB: " + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this.lockB) {
                System.out.println(Thread.currentThread().getName() + "持有lockB:" + lockB + "  尝试获取lockA " + lockA);
            }
        }
    }
}
