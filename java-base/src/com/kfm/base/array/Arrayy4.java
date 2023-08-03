package com.kfm.base.array;

import java.util.Scanner;

public class Arrayy4 {
    public static void main(String[] args) {


        Scanner inpu = new Scanner(System.in);
        System.out.println("请输入一个值");
        int n = inpu.nextInt();
        int []a = {2,3,1,8,3,9,6};

        for (int i = 0;i < a.length -1;i++){
            for (int j = 0;j < a.length-1-i;j++){

                if (a[j] <a[j+1]){

                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }


        }
        for (int i = 0;i< a.length;i++){
            if (n == i+1){

                System.out.println(a[i]);
            }

        }

    }
}
