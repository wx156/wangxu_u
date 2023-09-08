package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Comparator;

public class Exer03 {
    public static void main(String[] args) {
        Employee em1 = new Employee("张三1",25,37.0);
        Employee em2 = new Employee("张三2",27,355.4);
        Employee em3 = new Employee("张三3",28,355.5);
        Employee em4 = new Employee("张三4",23,35.6);
        Employee em5 = new Employee("张三5",22,35.77);
        Employee em6 = new Employee("张三6",21,35.0);
        Employee em7 = new Employee("张三7",23,35.0);

        ArrayList<Employee> arr = new ArrayList();
        arr.add(em1);
        arr.add(em2);
        arr.add(em3);
        arr.add(em4);
        arr.add(em5);
        arr.add(em6);
        arr.add(em7);

        arr.stream()
                .sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                if (o2.getSalary() == o1.getSalary()){
                    return o1.getAge() - o2.getAge();
                }
                return o2.getSalary() == o1.getSalary() ? 0: o2.getSalary() > o1.getSalary() ? 1:-1;
            }
        })
                .limit(3)
                .forEach((e) -> System.out.println(e));

    }
}
