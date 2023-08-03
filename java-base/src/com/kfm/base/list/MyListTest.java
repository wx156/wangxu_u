package com.kfm.base.list;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList m = new MyList();
        m.add("a");
        m.add("b");
        m.add("c");
        m.add("d");
        m.add("a");
        m.add("f");
        System.out.println(m.lastIndexOf("a"));
        System.out.println(m.get(4));
        System.out.println(Arrays.toString(m.toArray()));
        System.out.println(m.remove(3));
        System.out.println(m.remove("b"));
        System.out.println(Arrays.toString(m.toArray()));
    }
}
