package com.kfm.mybatis02.service.impl;


import com.kfm.mybatis02.dao.DeptMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeptServiceImplTest {
    @Autowired
    DeptMapper deptMapper;
    @Test
    public void selectAll() {
        deptMapper.selectAll().forEach(System.out::println);
    }
}