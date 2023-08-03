package com.kfm.base.collection.list.arraylist;

import com.kfm.base.collection.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayList1 {
    public static void main(String[] args) {
        Student student1 = new Student("张三",16);
        Student student2 = new Student("张三",27);
        Student student3 = new Student("张三",14);
        Student student4 = new Student("张三",16);
        Student student5 = new Student("张三",22);

        List <Student> vector= new Vector();

        vector.add(student1);
        vector.add(student2);
        vector.add(student3);
        vector.add(student4);
        vector.add(student5);
        vector.add(new Student("李四",37));

        for (Student s : vector){
            System.out.println(s);
        }
        ArrayList <Student>students = new ArrayList();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        List s = students.subList(2,4);
        s.add(0,new Student("李四",38));

        Iterator <Student>iterator = students.iterator();
        while (iterator.hasNext()){
            Student stu = iterator.next();
            System.out.println(stu);
        }
    }
}
