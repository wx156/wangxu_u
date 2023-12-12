package com.kfm.mybatis02.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GoodServiceImplTest {
    @Autowired
    private GoodServiceImpl goodService;
    @Test
    void findById() {
        System.out.println(goodService.findById(1));
    }
}