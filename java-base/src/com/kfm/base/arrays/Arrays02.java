package com.kfm.base.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays02 {
    public static int [][]triangle(int n){
        int [][]a = new int[n][n];
        int begin = 0;
        int end = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == begin || j == end){
                    a[i][j] = 1;
                }else {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }

            }

        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入行数");
        int a = in.nextInt();
        int [][]s = triangle(a);
        for (int i = 0; i < s.length; i++) {
            System.out.println(Arrays.toString(s[i]));
        }

    }
}
