package com.kfm.base.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exer2 {
    public static void main(String[] args) {
        String s = "eets";
        String t = "sees";
        System.out.println(compare(s, t));
    }

    private static boolean compare(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            s1.add(s.substring(i,i+1));
        }
        for (int i = 0; i < s.length(); i++) {
            s2.add(t.substring(i,i+1));
        }


        String com1 = s1.stream().sorted().collect(Collectors.joining());
        String com2 = s2.stream().sorted().collect(Collectors.joining());

        if (com1.compareTo(com2) == 0){
            return true;
        }
        return false;
    }
}
