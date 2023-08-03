package com.kfm.base.list;

import java.util.Arrays;

public class LinkedTest {
    public static void main(String[] args) {
        Linked linked = new Linked();

        System.out.println(linked.isEmpty()); // true

        linked.add("a");
        linked.add("b");
//        linked.add("c");
//        System.out.println(linked.toString());
//
//        System.out.println(linked.size()); // 1
//        System.out.println(linked.contains("a"));
//        System.out.println(linked.get(2));
//        linked.remove("a");
//        System.out.println(linked.set(0,1));
//        linked.add(2,"2");
        System.out.println(linked.remove(3));
        System.out.println(Arrays.toString(linked.toArray()));
    }
}
