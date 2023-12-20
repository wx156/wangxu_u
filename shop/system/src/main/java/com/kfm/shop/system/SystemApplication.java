package com.kfm.shop.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kfm.shop.system", "com.kfm.shop.common"})
@MapperScan("com.kfm.shop.system.mapper")
public class SystemApplication {
    public static void main(String[] args) {
        // 启动类，程序入口
        System.out.println("Hello World!");
        SpringApplication.run(SystemApplication.class, args);
    }
}
