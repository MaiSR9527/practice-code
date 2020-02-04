package com.msr.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/9 22:33
 * @version: v1.0
 */
@Service
@Slf4j
public class HelloService {

    public void hello(){
      log.info("this method hello in HelloService");
    }

    public void getByReflect(){
        log.info("this is a method to test aop to reflect in service");
    }
}
