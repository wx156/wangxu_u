package com.kfm.base.array;

import java.util.Random;
import java.util.Scanner;

public class Array6 {
    public static void main(String[] args) {

        Random rr = new Random();
        Scanner inp = new Scanner(System.in);
        System.out.println("请输入一个20-40的数");
        int num = inp.nextInt();
        int[] a = new int[20];
        int count = 0;


        if (num < 20 || num > 40) {
            System.out.println("你输入的数字不在指定范围内，请重新输入一个20-40的数字");
        } else {
            for (int i = 0; i < a.length; i++) {

                a[i] = rr.nextInt(20) + 20;
                if (a[i] == num) {
                    count += 1;

                }


            }
            System.out.println("你输入的数字是：" + num + "\n" + "出现的次数是：" + count);

        }

    }
}
