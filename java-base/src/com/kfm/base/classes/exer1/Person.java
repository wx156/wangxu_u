package com.kfm.base.classes.exer1;

import java.util.Objects;

public class Person {
    private String name;
    private Character gender;
    private Integer age;
    private Boolean marry;
    public Person(){
    }

    public Person(String name, Character gender, Integer age, Boolean marry) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.marry = marry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarry() {
        return marry;
    }

    public void setMarry(Boolean marry) {
        this.marry = marry;
    }

    public String info(String name,Character gender,Integer age,Boolean marry) {
        return "我的名字是：" + name + '\'' +
                ", 性别：" + gender +
                ", 年龄：" + age +
                ", 婚姻状态（未结婚为 true，结婚为false）：" + marry
                ;
    }

    @Override
    public String toString() {
        return "姓名：'" + name + '\'' +
                ", 性别：" + gender +
                ", 年龄：" + age +
                ", 婚姻状态（未结婚为 true，结婚为false）：" + marry
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(gender, person.gender) && Objects.equals(age, person.age) && Objects.equals(marry, person.marry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, marry);
    }
}
