package com.kfm.base.test1;

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

        /*
        将 s 的每个字符截取出来然后添加到集合里面去
         */
        for (int i = 0; i < s.length(); i++) {
            s1.add(s.substring(i,i+1));
        }
        /*
            将 t 的每个字符截取出来然后添加到另一个集合里面去
         */
        for (int i = 0; i < s.length(); i++) {
            s2.add(t.substring(i,i+1));
        }
        /*
            将两个集合排序后再转换为字符串
         */
        String com1 = s1.stream().sorted().collect(Collectors.joining());
        String com2 = s2.stream().sorted().collect(Collectors.joining());
        /*
            然后两个字符串相比较，如果一样则返回true
            不同返回false
         */
        if (com1.compareTo(com2) == 0){
            return true;
        }
        return false;
    }
}
