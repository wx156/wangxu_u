package com.kfm.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.plus.domain.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeptMapperTest {
    @Autowired
    private DeptMapper deptMapper;
    @Test
    void test() {
        System.out.println(deptMapper.selectById(1));
    }
}