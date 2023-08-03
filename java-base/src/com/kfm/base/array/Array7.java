package com.kfm.base.array;

import java.util.Scanner;

public class Array7 {

    public static void main(String[] args) {
        Scanner inpu = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int num = inpu.nextInt();

        int sum = 0;
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("请输入数组内第" + (i + 1) + "个元素,0-9,包括0和9");
            a[i] = inpu.nextInt();

        }
        for (int i = 0; i < a.length; i++) {

            sum += a[i] * Math.pow(10, num - i - 1);

        }
        System.out.println("这个数组表示的整数值为：" + sum);
    }

}
