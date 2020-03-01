package com.msr.algorithm;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/27 17:27
 * @version: v1.0
 */

public class TokenBucket {

    public static void main(String[] args) {
        //标识桶容量为5，且每秒新增5个令牌,速度：每200毫秒放入一个令牌
        RateLimiter limiter = RateLimiter.create(5);
        //从令牌获取令牌桶中获取一个令牌所花的时间单位
        System.out.println(limiter.acquire(3));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        /*for (int i = 0; i < 50; i++) {
            new Thread(()->{
                System.out.println(limiter.acquire(1));
            },"thread"+i).start();
        }*/
    }
}
