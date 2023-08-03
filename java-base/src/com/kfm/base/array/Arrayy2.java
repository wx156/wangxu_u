package com.kfm.base.array;

import java.util.Scanner;

public class Arrayy2 {
    public static void main(String[] args) {
        Scanner ipu = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int n = ipu.nextInt();

        int [] a = {22,3,2,5,77,44,21};

        for (int i = 0;i < a.length;i++) {
            if (a[i] == n) {

                System.out.println(i);
                break;

            }else
                System.out.println(-1);
                break;
        }

    }
}
