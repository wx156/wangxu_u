package com.kfm.shop.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kfm.shop.goods", "com.kfm.shop.common"})
@MapperScan("com.kfm.shop.goods.mapper")
public class GoodApplication {
    public static void main(String[] args) {
        // 启动类，程序入口
        SpringApplication.run(GoodApplication.class, args);
        System.out.println("商品模块启动成功");
    }
}
