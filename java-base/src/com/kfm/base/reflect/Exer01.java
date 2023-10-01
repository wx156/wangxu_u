package com.kfm.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Exer01 {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.kfm.base.reflect.Student");
            Student student = new Student();
            Class<? extends Student> aClass1 = student.getClass();

//            System.out.println(aClass);
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class,String.class,int.class);
            System.out.println(declaredConstructor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Method[] getAllMethod(Class cla){


        return null;

    }
}
class Person{
    String Pname;
    public String Pmanger;
    protected int Pid;
    private double Pscore;

    void Psay(){
        System.out.println("say");
    }
    public void Pstudy(){
        System.out.println("study");
    }
    protected void Peat(){
        System.out.println("eat");
    }
    private void Psleep(){
        System.out.println("sleep");
    }
}
class Student extends Person{
    String name;
    public String manger;
    protected int id;
    private double score;

    public Student() {
    }

    Student(String name, String manger) {
        this.name = name;
        this.manger = manger;
    }

    private Student(String name, String manger, int id) {
        this.name = name;
        this.manger = manger;
        this.id = id;
    }

    protected Student(String name, String manger, int id, double score) {
        this.name = name;
        this.manger = manger;
        this.id = id;
        this.score = score;
    }
    void say(){
        System.out.println("say");
    }
    public void study(){
        System.out.println("study");
    }
    protected void eat(){
        System.out.println("eat");
    }
    private void sleep(){
        System.out.println("sleep");
    }
}