package com.kfm.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kfm.goods.mapper")
public class GoodApplication {
    public static void main(String[] args) {
        // 启动类，程序入口
        System.out.println("Hello World!");
        SpringApplication.run(GoodApplication.class, args);
    }
}
