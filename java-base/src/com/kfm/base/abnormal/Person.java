package com.kfm.base.abnormal;

public class Person {
    public String name;
    public int age;

    public String gender;

    public Person() {
        this.name = "宋江";
    }

    public Person(String name) {
        this.name = name;
    }

    public void work (){
        System.out.println(this.name + "的工作理念是：让老板挣大钱");
    }
    public void work (String content){
        System.out.println(this.name + "的工作理念是：" + content);
    }
}
class Main{
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "宋江";
        p1.gender = "男";
        p1.age = 32;

        Person p2 = new Person();
        p2.name = "鲁智深";
        p2.gender = "男";
        p2.age = 28;

        Person p3 = new Person();
        p3.name = "武松";
        p3.gender = "男";
        p3.age = 30;

        Person [] people = new Person[]{
                p1,
                p2,
                p3
        };
        for (int i = 0; i < 3; i++) {
            System.out.println(people[i].name + ", " + people[i].gender + ", " + people[i].age);
        }
    }
}
