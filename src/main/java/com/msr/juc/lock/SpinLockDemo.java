package com.msr.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description: A线程加锁后沉睡5秒然后解锁，B线程加锁解锁
 * @author: MaiShuRen
 * @date: 2020/2/6 14:00
 * @version: v1.0
 */

public class SpinLockDemo {

    /**
     * 原子引用线程
     */
    static AtomicStampedReference<Thread> atomicThread = new AtomicStampedReference<>(null, 1);


    public static void main(String args[]) {
        new Thread(() -> {
            myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myUnLock();
            }
        }, "AAA").start();

        new Thread(() -> {
            myLock();
            myUnLock();
        }, "BBB").start();
    }


    public static void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " come in,version is " + atomicThread.getStamp());
        while (!atomicThread.compareAndSet(null, thread, 1, 2)) {
            System.out.println("加锁失败");
        }
        System.out.println(thread.getName() + "加锁成功");
        System.out.println(thread.getName() + " come out,version is " + atomicThread.getStamp());
    }

    public static void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " come in,version is " + atomicThread.getStamp());
        while (!atomicThread.compareAndSet(thread, null, 2, 1)) {
            System.out.println("解锁失败");
        }
        System.out.println(thread.getName() + "解锁成功");
        System.out.println(thread.getName() + " come out,version is " + atomicThread.getStamp());
    }

}
