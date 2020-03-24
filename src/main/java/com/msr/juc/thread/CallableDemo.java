package com.msr.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/3/2 17:07
 * @version: v1.0
 */

public class CallableDemo implements Callable<Integer> {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new CallableDemo());
        new Thread(task,"name").start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int a = 1;
        int b = 2;
        return a + b;
    }
}
