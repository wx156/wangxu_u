package com.kfm.base.annotation;

import java.time.LocalDate;

@Exer01
public class Student {
    @Exer01
    private String name;
    @Exer01
    private int age;
    public Student(){

    }
    private LocalDate date = LocalDate.now();
    @Exer01
    @Log(value = "执行了study方法")
    public void study(){
        System.out.println("study");
    }
}
