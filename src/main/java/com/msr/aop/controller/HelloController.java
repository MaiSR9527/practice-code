package com.msr.aop.controller;

import com.msr.aop.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/9 22:26
 * @version: v1.0
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        log.info("this is method in HelloController!");
        helloService.hello();
        return "hello AOP";
    }

    public void getByReflect(){
        log.info("this is a method to test aop to reflect in controller");
    }
}
