package com.kfm.base.array;

public class Array5 {
    public static void main(String[] args) {

        int[] a = {9, 1, 3, 4, 54, 56, 23, 22, 20, 43, 45, 78};
        for (int i = 0; i < a.length; i++) {

            if (a[i] % 6 == 0) {

                System.out.println(a[i]);
            }
        }
    }
}
