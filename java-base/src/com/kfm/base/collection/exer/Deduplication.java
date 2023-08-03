package com.kfm.base.collection.exer;

import com.kfm.base.collection.Student;

import java.util.HashSet;

public class Deduplication {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Student student1 = new Student("张三",16);
        Student student2 = new Student("张三",27);
        Student student3 = new Student("张三",14);
        Student student4 = new Student("张三",16);
        Student student5 = new Student("张三",22);

        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        hashSet.add(student4);
        hashSet.add(student5);

        System.out.println(hashSet.size());
        for (Object obj : hashSet){
            System.out.println(obj);
        }
    }
}
