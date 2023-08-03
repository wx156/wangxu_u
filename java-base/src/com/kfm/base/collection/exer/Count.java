package com.kfm.base.collection.exer;

import java.util.HashSet;

public class Count {
    public static void main(String[] args) {
        String str = "abcdefgsdffs";
        StringBuilder s = new StringBuilder(str);

        HashSet<String> a = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            a.add(s.substring(i, i + 1));
            
        }
        System.out.println(a);
    }
}
