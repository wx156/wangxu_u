package com.kfm.base.collection.list.linkedlist;

import com.kfm.base.collection.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedList1 {
    public static void main(String[] args) {

        LinkedList <Student>list = new LinkedList<>();

        Student student1 = new Student("张三",16);
        Student student2 = new Student("张三",27);
        Student student3 = new Student("张三",14);
        Student student4 = new Student("张三",16);
        Student student5 = new Student("张三",22);

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);


        System.out.println(list.peekFirst());
        List list1  = list.subList(0,3);
        list1.add(new Student("李四",28));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
        System.out.println(list.indexOf(student3));
    }
}
