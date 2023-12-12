package com.kfm.plus.service.impl;

import com.kfm.plus.domain.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeptServiceImplTest {
    @Autowired
    private DeptServiceImpl deptService;
    @Test
    void test(){
        deptService.list().forEach(System.out::println);
    }

}