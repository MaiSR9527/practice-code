package com.msr.aop.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.msr.annotation.Limiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/27 20:55
 * @version: v1.0
 */
@Aspect
@Component
public class LimiterAspect {

    @Resource
    private HttpServletResponse response;

    /**
     * 创建一个令牌桶限流器
     */
    private RateLimiter rateLimiter = RateLimiter.create(10);

    @Pointcut(value = "execution(public * com.msr.aop.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

        //使用反射技术获取方法上是否有@Limiter注解类
        Limiter annotation = signature.getMethod().getDeclaredAnnotation(Limiter.class);
        if (annotation == null) {
            //正常执行方法
            return proceedingJoinPoint.proceed();
        }
        //获取注解上的参数,获取配置的速率
        double rate = annotation.rate();
        long timeOut = annotation.timeOut();
        //设置限流速率
        rateLimiter.setRate(rate);
        boolean tryAcquire = rateLimiter.tryAcquire(timeOut, TimeUnit.MILLISECONDS);
        if (!tryAcquire) {
            //服务降级
            fallback();
            return null;
        }
        //得到令牌,正常执行
        return proceedingJoinPoint.proceed();
    }

    /**
     * 服务降级方法
     */
    private void fallback() {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("被降级了");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
