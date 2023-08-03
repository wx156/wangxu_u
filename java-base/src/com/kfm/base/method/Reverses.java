package com.kfm.base.method;

import java.util.Arrays;

public class Reverses {
    public static int[] reverses(int [] a){
        for (int i = 0; i < a.length >> 1; i++) {
            for (int j = a.length>>1+1; j < a.length; j++) {
                if (i + j == a.length -1){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

//    public static void main(String[] args) {
//        int a [] = {1,2,3,4,5};
//        reverses(a);
//    }
}
