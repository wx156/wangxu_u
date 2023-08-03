package com.kfm.base.collection.exer;

import com.kfm.base.collection.Student;

import java.util.ArrayList;
import java.util.List;

public class Union {
    public static void main(String[] args) {
        Student student1 = new Student("张三",15);
        Student student2 = new Student("张三",27);
        Student student3 = new Student("张三",14);
        Student student4 = new Student("张三",16);
        Student student5 = new Student("张三",22);

        List list1 = new ArrayList();
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
//        list1.add(student4);
        list1.add(student5);

        List list2 = new ArrayList();
        list2.add(student1);
        list2.add(student2);
        list2.add(student3);
        list2.add(student4);

        List list = union(list2,list1);
        for (Object o : list){
            System.out.println(o);
        }
    }
    public static List union(List list1, List list2){
        List list = new ArrayList<>();
        if (list1.size() >= list2.size()){
            for (int i = 0; i < list2.size(); i++) {
                if (!list1.contains(list2.get(i))){
                    list1.add(list2.get(i));
                    list = list1;
                }
            }
        }
        else {
            for (int i = 0; i < list1.size(); i++) {

                if (!list2.contains(list1.get(i))){
                    list2.add(list1.get(i));
                    list = list2;
                }
            }
        }
        return list;
    }
}
