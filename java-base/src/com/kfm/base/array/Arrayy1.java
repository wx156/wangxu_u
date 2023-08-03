package com.kfm.base.array;

import java.util.Arrays;
import java.util.Scanner;

public class Arrayy1 {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("请输入有几个学生");
        int n = inp.nextInt();
        int []a = new int[n];


        for (int i = 0;i < a.length;i++){

            System.out.println("请输入第" + (i+1) + "个同学的成绩");
            a[i] = inp.nextInt();

        }

        for (int j = 0;j < a.length-1;j++){
            if (a[j] < a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }

        }
        System.out.println(Arrays.toString(a));
    }
}
