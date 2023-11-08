package com.kfm.mybatis02.util;

import java.util.UUID;

public class IdUtil {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
    public static String uuid32() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
