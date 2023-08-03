package com.kfm.base.array;

import java.util.Scanner;

public class Array9 {
    public static void main(String[] args) {
        double[] a = new double[6];
        double min = a[0];
        double max = a[0];
        double sum = 0;
        double avg = 0;

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的打分");
            a[i] = input.nextDouble();


        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];

            }
            sum += a[i];
            avg = (sum - max - min) / 4;
        }
        System.out.println("选手的分数为：" + avg);

    }
}
