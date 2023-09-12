package com.kfm.base.test1;

public class Exer1 {
    public static void main(String[] args) {
        String s = "  the sky is blue";
        String ss = reserve(s);
        System.out.println(ss);
    }

    private static String reserve(String s) {
        s = s.trim();
        String[] str = s.split(" ");

        StringBuilder stu = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i --) {
            if (str[i] != ""){
                stu.append(str[i]).append(" ");
            }
        }
        stu.replace(stu.length()-1,stu.length(),"");
        return stu.toString();
    }

}
