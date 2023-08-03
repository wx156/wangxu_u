package com.kfm.base.array;

import java.util.Random;
import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner nu = new Scanner(System.in);
        Random r = new Random();
        int num = 0;


        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个1至60之间的数字");
            a[i] = nu.nextInt();


        }
        num = r.nextInt(8) + 2;
        for (int j = 0; j < a.length; j++) {

            if (a[j] % num != 0) {
                System.out.println(a[j]);
            }
        }
    }
}
