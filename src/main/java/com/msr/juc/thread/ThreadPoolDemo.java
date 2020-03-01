package com.msr.juc.thread;

import java.util.concurrent.*;

/**
 * @description: 手写线程池
 * @author: MaiShuRen
 * @date: 2020/2/6 13:31
 * @version: v1.0
 */

public class ThreadPoolDemo {

    /**
     * AbortPolicy 直接报异常
     * CallerRunsPolicy 回退给调用线程 main --> work
     * DiscardOldestPolicy 抛弃队列中等待最久的任务,然后把当前任务加入队列中尝试再次提交
     * DiscardPolicy 直接抛弃
     * maximumPoolSize CPU密集型：CPU数+1  IO密集型：1.CPU数/(1-阻塞系数) 2. 阻塞系数：0.8~0.9
     * @param args args
     */
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    /*try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName()+" --> work");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
