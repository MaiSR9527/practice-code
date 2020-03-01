package com.msr.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/27 20:51
 * @version: v1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limiter {

    //放令牌的速率
    double rate();
    //获取令牌的超时时间
    long timeOut() default 0;
}
