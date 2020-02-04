package com.msr.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/9 22:16
 * @version: v1.0
 */
@Aspect
@Component
@Slf4j
public class WebLogApsect {

    @Pointcut("execution(public * com.msr.aop.controller..*.*(..))")
    public void controllerLog() {

    }

    @Pointcut("execution(public * com.msr.aop.service..*.*(..))")
    public void serviceLog() {

    }

    @Before("controllerLog()")
    public void logBefore(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = requestAttributes != null ? ((ServletRequestAttributes) requestAttributes).getRequest() : null;
        if (ObjectUtils.isEmpty(servletRequest)) {
            log.info("none request");
        } else {
            log.info("Http Method is " + servletRequest.getMethod());
            log.info("URL is" + servletRequest.getRequestURL().toString());
            log.info("URI is" + servletRequest.getRequestURI());
        }
    }

    @After("controllerLog() || serviceLog()")
    public void logAfter(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        Class<?> aClass = target.getClass();
        Constructor<?> constructor = null;
        try {
            constructor = aClass.getConstructor();
            Object o = constructor.newInstance();
            Method getByReflect = o.getClass().getMethod("getByReflect");
            getByReflect.invoke(o);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        log.info("current class is"+joinPoint.getTarget().getClass());
        log.info("aspect after");
    }
}
