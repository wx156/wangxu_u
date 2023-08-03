package com.kfm.base.arrays;

import java.util.Scanner;

public class Arrays4 {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("请输入行数");
        int n = inp.nextInt();

        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                int start = 0;
                int end = a.length;
                if (j == start || j == end) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }

                System.out.print(a[i][j] + "\t");
            }
            System.out.println();

        }
    }
}
