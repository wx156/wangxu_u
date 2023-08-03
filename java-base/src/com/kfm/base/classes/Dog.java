package com.kfm.base.classes;

public class Dog {
    public String color;
    public String breed;
    public String eat(){
        return (color + "的" +breed+ "正在啃骨头");
    }
    public String housekeeping(){
        return (color + "的" +breed+ "正在看家");
    }
}
