package com.kfm.base.collection;

import java.util.Collection;
import java.util.Set;

public class Collection1 {
    public static void main(String[] args) {
        Collection set = Set.of("a","b","c");
        System.out.println(set.isEmpty());
        System.out.println(set.size());
    }
}
