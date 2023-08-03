package com.kfm.base.array;

import java.util.Arrays;

public class Array12 {
    public static void main(String[] args) {

        int[] a = {3, 2, 55, 33, 76, 48, 9, 20, 66};
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - 1 - i; j++) {

                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
