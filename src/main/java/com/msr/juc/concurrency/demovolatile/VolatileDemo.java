package com.msr.juc.concurrency.demovolatile;

/**
 * @description: 测试volatile可见性
 * @author: MaiShuRen
 * @date: 2019/12/21 14:24
 * @version: v1.0
 */

public class VolatileDemo {


    public static void main(String[] args) {
        MyData myData = new MyData();

        //测试volatile保证可见性
//        testVisibility();

        //测试volatile不保证可见性
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.add();
                }
            }, String.valueOf(i)).start();
        }
        //
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "finaly value j = " + myData.j);

    }

    /**
     * volatile保证可见性
     */
    private static void testVisibility() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.visible();
            System.out.println(Thread.currentThread().getName() + "update j = " + myData.j);
        }, "thread-data").start();

        while (myData.j == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "can see j = " + myData.j);
    }
}

class MyData {
    /**
     * 无可见性
     */
    int i = 0;
    /**
     * volatile保证可见性
     */
    volatile int j = 0;


    public void notVisible() {
        this.i = 60;
    }

    public void visible() {
        this.j = 60;
    }

    public void add() {
        /**
         * 取值加载到工作内存-在工作内存里运算-刷新到主内存
         * 存在问题：多个线程取到一样的值，都加1后，没来得及通知其他线程，其他线程的值都是只加1。
         * 解决volatile原子性：
         *      1、synchronized可以保证原子性，但是是重量级的
         *      2、原子类
         */
        j++;
    }

}
