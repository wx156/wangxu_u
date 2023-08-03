package com.kfm.base.collection;

import java.util.Objects;

/**
 * 创建一个集合， 存储 5 个 Student 对象(name, age, toString, equals, hashCode, getter/setter).
 *  1. 设计方法对集合元素，按照年龄进行排序
 *  2. 输出排序后的集合元素
 *  3. 删除将下标为 3 的学生的姓名改成 "三娃"
 *  4. 在下标为 4 处添加学生 五娃 20岁
 *  6. 删除最后一个学生
 *  7. 遍历输出每个学生的姓名
 */
public class Student {
    private String name;
    private Integer age;
    private Double score;


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
