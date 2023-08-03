package com.kfm.base.collection.hashmap;

import java.util.HashMap;

public class Map2 {
    public static void main(String[] args) {
        String s = "abcdabcde";
        HashMap<String, Integer> hashMap = new HashMap<>();
        Integer count;
        for (int i = 0; i < s.length(); i++) {
            String s1 = s;
            count = s.length() - (s1.replace(s.substring(i, i + 1), "")).length();
            hashMap.put(s.substring(i, i + 1), count);
        }
        System.out.println(hashMap);
    }
}
