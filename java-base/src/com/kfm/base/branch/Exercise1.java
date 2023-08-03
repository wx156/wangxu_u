package com.kfm.base.branch;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入一个数字：\n");
        int a = input.nextInt();

        System.out.println("请输入一个操作符号\n");
        String t = input.next();

        System.out.println("请再输入一个数字：\n");
        int b = input.nextInt();

        switch (t) {
            case "+" -> System.out.println(a + b);
            case "-" -> System.out.println(a - b);
            case "*" -> System.out.println(a * b);
            case "/" -> System.out.println(a / b);
            default -> System.out.println("无效的运算符");
        }


    }

}
