package com.msr.juc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentryLock实现交替执行
 * @author: MaiShuRen
 * @date: 2020/2/29 23:38
 * @version: v1.0
 */

public class AwaitSignalDemo {
    public static void main(String[] args) {
        ShareData2 shareData2 = new ShareData2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData2.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareData2.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }

}

class ShareData2 {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            ++number;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void decr() throws InterruptedException {

        lock.lock();
        try {
            //判断
            while (number != 1) {
                condition.await();
            }
            //干活
            --number;
            System.out.println(Thread.currentThread().getName() + " \t " + number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
