package com.kfm.base.array;

import java.util.Arrays;

public class Array14 {
    public static void main(String[] args) {

        int [] a= {1, 8, 6, 5, 9, 33, 24};
        for (int i = 1;i < a.length;i++){
            int c = a[i];
            int p = i - 1;
            while (p >= 0 && a[p] > c){

                a[p + 1] = a[p];
                p--;
            }
            a[p + 1] = c;

        }
        System.out.println(Arrays.toString(a));
    }
}

