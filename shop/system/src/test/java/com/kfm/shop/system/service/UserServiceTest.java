package com.kfm.shop.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.shop.system.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void test() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "admin");
        queryWrapper.eq("password", "a123456");
        User user = userService.getOne(queryWrapper);
        System.out.println(user);
    }
}