package com.kfm.base.classes.cinema;

import com.kfm.base.string.Work2plus;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner inpu = new Scanner(System.in);
        System.out.println("请输入一个只包含括号的字符串：");
        String a = inpu.next();
        Work2plus w = new Work2plus();
        boolean b = w.determine(a);
        System.out.println(b);
    }
}
