package com.kfm.base.branch;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个月份");
        int result = in.nextInt();
        switch (result) {
            case 3, 4, 5 -> System.out.println("你输入的月份在春季");
            case 6, 7, 8 -> System.out.println("你输入的月份在夏季");
            case 9, 10, 11 -> System.out.println("你输入的月份在秋季");
            case 12, 1, 2 -> System.out.println("你输入的月份在冬季");
            default -> System.out.println("输入错误");
        }

    }
}
