package com.kfm.base.string;

import java.util.Scanner;

public class Work2 {
    public static void main(String[] args) {
        Scanner inpu = new Scanner(System.in);
        System.out.println("请输入一个只包含括号的字符串：");
        String a = inpu.next();
        boolean b = determine(a);
        System.out.println(b);
    }
    public static boolean determine(String str){
        String a = str;
        int count1 = 0;
        int count2 = 0;
        if (str.length() % 2 != 0){
            return false;
        }else {
            for (int i = 0; i < str.length(); i++) {
                str = a.replace("(","");
                count1++;
            }
            for (int i = 0; i < str.length(); i++) {
                str = a.replace(")","");
                count2++;
            }
            if (count1 != count2){
                return false;
            }else if(!determine1(a)){
                return false;
            }else {
                return true;
            }
        }

    }
    public static boolean determine1(String str){
        for (int i = 0; i < str.length(); i++) {
            str = str.replace("()","");
            return str.length() == 0;
        }
        return true;
    }
}
