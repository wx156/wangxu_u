package com.kfm.base.classes.exer;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private double score;
    public Student(String name,int age,String studentId,double score){
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.score = score;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double score){
        this.score = score;
    }

}
