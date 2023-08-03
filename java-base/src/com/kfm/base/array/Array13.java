package com.kfm.base.array;

import java.util.Arrays;

public class Array13 {
    public static void main(String[] args) {

        int[] a = {1, 8, 6, 5, 9, 33, 24};

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {

                if (a[j] < a[min]) {

                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;

        }
        System.out.println(Arrays.toString(a));
    }
}
