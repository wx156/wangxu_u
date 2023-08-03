package com.kfm.base.array;

public class Array10 {
    public static void main(String[] args) {

        int[] a = {1, 8, 5, 33, 44, 22, 99, 55, 35, 78};

        for (int i = 0; i < a.length / 2; i++) {

            for (int j = a.length - 1; j >= 0; j--) {
                if (i + j == 9) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    continue;
                }

            }

        }
        for (int s : a
        ) {
            System.out.print(s + " ");
        }
    }
}
