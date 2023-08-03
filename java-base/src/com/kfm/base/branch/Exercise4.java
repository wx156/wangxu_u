package com.kfm.base.branch;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner p = new Scanner(System.in);

        System.out.println("请输入你的工资");
        int money = p.nextInt();

        System.out.println("请输入你的工龄");
        int time = p.nextInt();

        if (time <= 5) {
            double result1 = money * 0.05;
            System.out.println(result1);
        } else if (time >= 5 & time <= 10) {
            double result2 = money * 0.1;
            System.out.println(result2);
        } else if (time > 10) {
            double result3 = money * 0.15;
            System.out.println(result3);
        }
    }
}
