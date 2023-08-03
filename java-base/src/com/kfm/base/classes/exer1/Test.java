package com.kfm.base.classes.exer1;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("张三",'男',23,true);
        Person person2 = new Person("李四",'女',23,true);
        CAB a = new CAB();
        a.canMary(person1,person2);
    }
}
