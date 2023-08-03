package com.kfm.base.collection.exer;

import com.kfm.base.collection.Student;

import java.util.ArrayList;
import java.util.List;

public class Difference {
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
//        list2.add(student5);

        List l = difference(list1,list2);
        for (Object o : l){
            System.out.println(o);
        }
    }

    /**
     * 求出 list1 相对于 list2 的差集
     * @param list1 传入的第一个集合，暂定为要求差集的集合
     * @param list2 以这个集合为基准求第一个集合的差集
     * @return
     */
    public static List difference(List list1,List list2){
        List list = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            if (!list1.contains(list2.get(i))){
                list.add(list1.get(i));
            }
        }
        return list;
    }
}
