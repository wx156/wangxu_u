package com.kfm.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kfm.plus.mapper")
public class PlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class, args);
    }
}
