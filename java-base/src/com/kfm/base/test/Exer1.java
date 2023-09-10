package com.kfm.base.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exer1 {
    public static void main(String[] args) {
        String s = "  the sky is blue";
        String ss = reserve(s);
        System.out.println(ss);
    }

    private static String reserve(String s) {
        s = s.trim();
        String ss = "";
        String[] strings = s.split(" ");
        List<String> arr = new ArrayList();

        for (int i = 0; i < strings.length; i++) {
            arr.add(strings[i]);
        }
        Collections.reverse(arr);
        for (Object a :arr) {
            ss += a + " ";
        }
        return ss;
    }

}
