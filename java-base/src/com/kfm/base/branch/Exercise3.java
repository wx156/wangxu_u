package com.kfm.base.branch;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("请输入一个月份");
        int mouth = s.nextInt();

        System.out.println("请输入一个日期");
        int day = s.nextInt();

        switch (mouth) {
            case 1 -> {
                if (day >= 20 && day <= 31) {
                    System.out.println("你输入的日期是水瓶座");
                } else if (day >= 1 && day < 20) {
                    System.out.println("你输入的日期是魔羯座");
                } else System.out.println("请输入正确的日期");

            }
            case 2 -> {
                if (day >= 19 && day <= 29) {
                    System.out.println("你输入的日期是双鱼座");
                } else if (day >= 1 && day < 19) {
                    System.out.println("你输入的日期是水瓶座");
                } else System.out.println("请输入正确的日期");
            }
            case 3 -> {
                if (day >= 21 && day <= 31) {
                    System.out.println("你输入的日期是白羊座");
                } else if (day >= 1 && day < 21) {
                    System.out.println("你输入的日期是双鱼座");
                } else System.out.println("请输入正确的日期");
            }
            case 4 -> {
                if (day >= 20 && day <= 30) {
                    System.out.println("你输入的日期是金牛座");
                } else if (day >= 1 && day < 20) {
                    System.out.println("你输入的日期是白羊座");
                } else System.out.println("请输入正确的日期");
            }
            case 5 -> {
                if (day >= 21 && day <= 31) {
                    System.out.println("你输入的日期是双子座");
                } else if (day >= 1 && day < 21) {
                    System.out.println("你输入的日期是金牛座");
                } else System.out.println("请输入正确的日期");
            }
            case 6 -> {
                if (day >= 21 && day <= 30) {
                    System.out.println("你输入的日期是巨蟹座");
                } else if (day >= 1 && day < 21) {
                    System.out.println("你输入的日期是双子座");
                } else System.out.println("请输入正确的日期");
            }
            case 7 -> {
                if (day >= 23 && day <= 31) {
                    System.out.println("你输入的日期是狮子座");
                } else if (day >= 1 && day < 23) {
                    System.out.println("你输入的日期是巨蟹座");
                } else System.out.println("请输入正确的日期");
            }
            case 8 -> {
                if (day >= 23 && day <= 31) {
                    System.out.println("你输入的日期是处女座");
                } else if (day >= 1 && day < 23) {
                    System.out.println("你输入的日期是狮子座");
                } else System.out.println("请输入正确的日期");
            }
            case 9 -> {
                if (day >= 23 && day <= 30) {
                    System.out.println("你输入的日期是天枰座");
                } else if (day >= 1 && day < 23) {
                    System.out.println("你输入的日期是处女座");
                } else System.out.println("请输入正确的日期");
            }
            case 10 -> {
                if (day >= 23 && day <= 31) {
                    System.out.println("你输入的日期是天蝎座");
                } else if (day >= 1 && day < 23) {
                    System.out.println("你输入的日期是天枰座");
                } else System.out.println("请输入正确的日期");
            }
            case 11 -> {
                if (day >= 22 && day <= 30) {
                    System.out.println("你输入的日期是射手座");
                } else if (day >= 1 && day < 22) {
                    System.out.println("你输入的日期是天蝎座");
                } else System.out.println("请输入正确的日期");
            }
            case 12 -> {
                if (day >= 22 && day <= 31) {
                    System.out.println("你输入的日期是摩羯座");
                } else if (day >= 1 && day < 22) {
                    System.out.println("你输入的日期是射手座");
                } else System.out.println("请输入正确的日期");
            }
            default -> System.out.println("请输入正确的月份");

        }
    }
}
