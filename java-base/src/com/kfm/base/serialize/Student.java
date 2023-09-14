package com.kfm.base.serialize;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private Integer age;
    private String gender;
    public Student(){}

    public Student(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
