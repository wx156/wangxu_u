package com.kfm.mybatis02.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IdUtilTest {
    @Test
    void getId() {
        for (int i = 0; i < 5; i++) {
            System.out.println(IdUtil.uuid32());
        }
    }
}