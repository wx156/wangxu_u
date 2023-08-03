package com.kfm.base.method;

public class Sum {
    public static int sum(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

//    public static void main(String[] args) {
//        int sum = sum(1,2);
//        System.out.println(sum);
//    }
}
