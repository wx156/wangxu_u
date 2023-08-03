package com.kfm.base.classes;

public class Animals {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.eat());
        System.out.println(cat.catchMouse());
        Dog dog = new Dog();
        dog.color = "黑色";
        dog.breed = "藏獒";
        System.out.println(dog.eat());
        System.out.println(dog.housekeeping());
    }
}
