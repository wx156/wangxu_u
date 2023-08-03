package com.kfm.base.collection;

import java.util.Vector;

public class Test1 {
    public static void main(String[] args) {
        Student student1 = new Student("张三",58.0);
        Student student2 = new Student("张三",48.0);
        Student student3 = new Student("张三",78.0);
        Student student4 = new Student("张三",98.0);
        Student student5 = new Student("张三",48.0);
        Student student6 = new Student("张三",58.0);
        Student student7 = new Student("张三",66.0);
        Student student8 = new Student("张三",55.0);
        Student student9 = new Student("张三",57.0);
        Student student10 = new Student("张三",48.0);

        Vector v = new Vector();
        v.add(student1);
        v.add(student2);
        v.add(student3);
        v.add(student4);
        v.add(student5);
        v.add(student6);
        v.add(student7);
        v.add(student8);
        v.add(student9);
        v.add(student10);

//        v.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Student stu1 && o2 instanceof Student stu2){
//                    return (int) (stu2.getScore() - stu1.getScore());
//                }
//                return 0;
//            }
//        });

        v.sort((o1, o2) -> {
            if (o1 instanceof Student stu1 && o2 instanceof Student stu2){
                return (int)(stu2.getScore() - stu1.getScore());
            }
            return 0;
        });


        System.out.println(v);

        Double a = avg(v);
        System.out.println(a);

    }

    private static Double avg(Vector v) {
        Double sum = 0.0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) instanceof Student){
                Student stu = (Student) v.get(i);
                sum += stu.getScore();
            }
        }
        return sum / v.size();
    }
}
