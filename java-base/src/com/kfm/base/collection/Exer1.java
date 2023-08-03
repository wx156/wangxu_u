package com.kfm.base.collection;

import java.util.Comparator;
import java.util.Vector;

/**
 * 创建一个集合， 存储 5 个 Student 对象(name, age, toString, equals, hashCode, getter/setter).
 *  1. 设计方法行排序
 *  2. 输出排序后的集合元素
 *  3. 将下标为 3 的学生的姓名改成 "三娃"
 *  4. 在下标为 4 处添加学生 五娃 20岁
 *  6. 删除最后一个学生
 *  7. 遍历输出每个学生的姓名
 */
public class Exer1 {
    public static void main(String[] args) {

        Student student1 = new Student("张三",16);
        Student student2 = new Student("张三",27);
        Student student3 = new Student("张三",14);
        Student student4 = new Student("张三",16);
        Student student5 = new Student("张三",22);

        Vector vector = new Vector();

        vector.add(student1);
        vector.add(student2);
        vector.add(student3);
        vector.add(student4);
        vector.add(student5);

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student stu1 = (Student) o1;
                Student stu2 = (Student) o2;
                return stu1.getAge() - stu2.getAge();
            }
        };
        sort(vector,c);
        System.out.println(vector);
        for (Object obj : vector){
            System.out.println(obj);
        }
        Student student = (Student) vector.get(3);
        student.setName("三娃");
        System.out.println(vector.get(3));
        vector.add(new Student("五娃",20));
        System.out.println(vector);
        vector.remove(vector.size()-1);
        System.out.println(vector);
        for (Object obj : vector) {
            if (obj instanceof Student){
                Student stu  = (Student)obj;
                System.out.println(stu.getName());
            }
        }
        //lambda 表达式
//        vector.sort((o1, o2) -> {
//            if (o1 instanceof Student stu1 && o2 instanceof Student stu2){
//                return stu1.getAge() - stu2.getAge();
//            }
//            return 0;
//        });
    }
    public static void sort(Vector vector, Comparator comparator){

        for (int i = 0; i < vector.size()-1; i++) {
            for (int j = 0; j < vector.size()-1-i; j++) {
                if (comparator.compare(vector.get(j),vector.get(j+1)) > 0){
                    Object temp = vector.get(j);
                    vector.set(j,vector.get(j+1));
                    vector.set(j+1,temp);
                }
            }
        }
    }
}
