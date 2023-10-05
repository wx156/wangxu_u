package com.kfm.base.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Exer01 {
    String name() default "张三";
    int age() default 20;
}
