package com.msr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2019/12/9 22:26
 * @version: v1.0
 */
//@MapperScan(basePackages = {"com.msr.mybatis"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
