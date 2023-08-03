package com.kfm.base.array;

public class Array1 {
    public static void main(String[] args) {

        int[] a = {33, 51, 78, 94, 26};
        int min = a[0];
        for (int i = 0; i < a.length; i++) {

            if (a[i] < min) {
                min = a[i];

            }

        }
        System.out.println(min);
    }
}
