package com.kfm.base.list;

public class DoubleLinkedTest {
    public static void main(String[] args) {
        DoubleLinked linked = new DoubleLinked();

        System.out.println(linked.isEmpty());

        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
        linked.add(null);



        System.out.println(linked.size());
        System.out.println(linked);

//        linked.remove("d");
//
//        System.out.println(linked);

//        System.out.println(linked.get(3));

//        System.out.println(linked.set(5, 6));
        System.out.println(linked.remove(2));
        System.out.println(linked);
    }
}
