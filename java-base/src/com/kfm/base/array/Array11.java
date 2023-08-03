package com.kfm.base.array;

import java.util.Arrays;

public class Array11 {
    public static void main(String[] args) {


        int[] a = {1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9,};
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            while (left < right) {

                if (a[left] % 2 == 0) {
                    break;
                }
                left++;
            }
            while (left < right) {

                if (a[right] % 2 != 0) {
                    break;
                }
                right--;
            }


            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
