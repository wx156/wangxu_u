package com.kfm.base.method;

import java.util.Arrays;

public class Exchange {
    public static int exchange(int a,int b,int ...c){
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (i==a && j==b){
                    int temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(c));
        return -1;
    }

//    public static void main(String[] args) {
//        int a= 2;
//        int b =5;
//        int [] c = {1,2,3,4,5,6,7,8};
//        exchange(a,b,c);
//    }
}
