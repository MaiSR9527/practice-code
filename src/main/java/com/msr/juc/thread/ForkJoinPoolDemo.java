package com.msr.juc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/5 11:11
 * @version: v1.0
 */

public class ForkJoinPoolDemo extends RecursiveTask<Integer> {

    private int start = 0;
    private int end = 0;

    public ForkJoinPoolDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinPoolDemo task = new ForkJoinPoolDemo(1, 100);
        forkJoinPool.submit(task);
        System.out.println(task.get());

    }

    @Override
    protected Integer compute() {
        if (end - start < 10) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
                System.out.println(Thread.currentThread().getName()+"  i="+sum);
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            ForkJoinPoolDemo left = new ForkJoinPoolDemo(this.start, middle);
            ForkJoinPoolDemo right = new ForkJoinPoolDemo(middle, this.end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}



